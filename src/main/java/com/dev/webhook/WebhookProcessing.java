package com.dev.webhook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dev.configuration.DBEngine;
import com.dev.graph.RetrivevUrlModel;

@Service
public class WebhookProcessing {
	
	public String triggerService() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/StarParts/TriggerFromWebhook";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.POST, entity, new ParameterizedTypeReference<String>() {
		});
//		String re = restTemplate.getForObject(url, String.class);
		String re = response.getBody().toString();
		System.out.println(re);
		return re;
		
	}
	public Map<String, Object> getAllParam(DataSourceProperties ds){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Object> res = new HashMap<String, Object>();
		String sql = "SELECT \"parameter_Name\", \"parameter_Value\" FROM \"parameter\"";
		try {
			conn = DBEngine.getConnection(ds);
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				res.put(rs.getString(1), rs.getObject(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public String extract(DataSourceProperties ds, String id, String phone, String fileName, String type) {
		String result = "";
		RestTemplate res = new RestTemplate();
		Map<String, Object> param = getAllParam(ds);
		String token = (String) param.get("wa.token");
		String url = (String) param.get("wa.url");
		String version = (String) param.get("wa.version");
		String uri = url+"/"+version+"/"+id;
		System.out.println(uri);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+token);
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<RetrivevUrlModel> response = res.exchange(uri,HttpMethod.GET, entity, new ParameterizedTypeReference<RetrivevUrlModel>() {
		});
		RetrivevUrlModel res1 = response.getBody();
//		System.out.println(res1.getUrl());
		RestTemplate res2 = new RestTemplate();
		HttpHeaders headers1 = new HttpHeaders();
		headers1.setContentType(MediaType.APPLICATION_JSON);
		headers1.set("Authorization", "Bearer "+token);
		HttpEntity<String> entity1 = new HttpEntity<String>("parameters",headers1);
		ResponseEntity<byte[]> tes = res2.exchange(res1.getUrl(), HttpMethod.GET, entity1, new ParameterizedTypeReference<byte[]>() {});
		
		String[] mime = res1.getMime_type().split("/");
		System.out.println(mime[1]);
		// Access the byte array from the ResponseEntity
        byte[] mediaContent = tes.getBody();
        String tmpFile = (String) param.get("path.media");
        File dir = new File(tmpFile+"/"+phone);
        dir.mkdir();
        if(type.equals("image")) {
        	fileName = id+"."+mime[1];
        }
        String savePath = phone+"/"+fileName;
        String pathFile = tmpFile+"/"+savePath;
        System.out.println(pathFile);
        if (mediaContent != null) {
            try {
                // Save the byte array to a file
//            	File file = new File("D:\\KERJABLOK\\StarParts\\issue");
                Path path = Path.of(pathFile);
                Files.write(path, mediaContent);
                System.out.println("Media saved to: " + path.toAbsolutePath());
                result =  savePath;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No media content received.");
        }
		
		
		return result;
	}
}
