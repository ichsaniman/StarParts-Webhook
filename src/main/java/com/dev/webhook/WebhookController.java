package com.dev.webhook;

import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.webhook.template.Conversation;
import com.dev.webhook.template.Origin;
import com.dev.webhook.template.Pricing;
import com.dev.webhook.template.TemplateMetadata;
import com.dev.webhook.template.TemplateStatuses;
import com.dev.webhook.template.WebhookHandleTemplate;
import com.dev.webhook.template.WebhookHandleTemplateChanges;
import com.dev.webhook.template.WebhookHandleTemplateValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.git.user.UserModel;


@RestController
@RequestMapping()
public class WebhookController {
	
	@Autowired
	private WebhookLogRepository logRepository;
	
	@Autowired
	private WebhookMessageRepository messageRepository;
	
	@Autowired
	private WebhookLiveRepository liveRepository;
	
	@Autowired
	DataSourceProperties dataSourceProperties;
	
	@Autowired
	private WebhookProcessing processing;
	
	
		
		@GetMapping("/webhook")
		public ResponseEntity<String> webhookVerify(@RequestParam("hub.mode") String mode,
													@RequestParam("hub.challenge") String challange,
													@RequestParam("hub.verify_token")String token){
			System.out.println(mode);
			System.out.println(token);
			System.out.println(challange);
			if(mode.equals("subscribe") && token.equals("dendy")) {
				return new ResponseEntity<>(challange, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Verification token or mode mismatch", HttpStatus.FORBIDDEN);				
			}
		}
		
		
		@PostMapping("/webhook")
		public void getRequest(@RequestBody String json1) throws JsonMappingException, JsonProcessingException  {
//			JSONObject mainJson = new JSONObject(json.toString());
			ObjectMapper om = new ObjectMapper();
			System.out.println(json1);
//			System.out.println(json1.contains("statuses"));
			if(!json1.contains("statuses")) {
				WebhookHandleModel json = om.readValue(json1, WebhookHandleModel.class);
//			System.out.println(toJson(json));
				if(json.getObject() !=null) {
					if(json.getEntry() !=null && !json.getEntry().isEmpty()) {
						WebhookHandleChanges change = json.getEntry().get(0).getChanges().get(0);
						if(change.getValue() !=null && change.getValue().getMessages() !=null && !change.getValue().getMessages().isEmpty()) {
							System.out.println(change.getValue().getMessages());
							
							WebhookHandleValue value = change.getValue();
							List<WebhookHandleMessages> messagesL = value.getMessages();
							WebhookHandleMessages messages = messagesL.get(0);
							if(UserModel.checkUser(messages.getFrom(), dataSourceProperties)) {
								
							
							
							if(messages.getType().equals("text")){
								WebhookModel model = new WebhookModel();
								WebhookLogModel log = new WebhookLogModel();
								WebhookHandleBody body = messages.getText();
								model.setId(messages.getId());
								model.setFrom(messages.getFrom());
								model.setType(messages.getType());
								model.setTime(messages.getTimestamp());
								model.setMessages(body.getBody());
								messageRepository.save(model);
								
								log.setId(messages.getId());
								log.setFrom(messages.getFrom());
								log.setStatus("Recived");
								log.setTime(messages.getTimestamp());
								log.setTo("Admin");
								log.setMessages(body.getBody());
								logRepository.save(log);
								
								
							}else if(messages.getType().equals("document")) {
								System.out.println(messages.getType());
								WebhookModel model = new WebhookModel();
								WebhookLogModel log = new WebhookLogModel();
								WebhookHandleDocument doc = messages.getDocument();
								String path = processing.extract(dataSourceProperties, doc.getId(), messages.getFrom(), doc.getFilename(), "doc");
								if(doc.getCaption() !=null) {
									model.setCaption(doc.getCaption());
									model.setFileName(doc.getFilename());
									model.setId(messages.getId());
									model.setFrom(messages.getFrom());
									model.setType(messages.getType());
									model.setTime(messages.getTimestamp());
									model.setMediaId(doc.getId());
									model.setPath(path);
									messageRepository.save(model);
									
									
								}else {
									model.setFileName(doc.getFilename());
									model.setId(messages.getId());
									model.setFrom(messages.getFrom());
									model.setType(messages.getType());
									model.setTime(messages.getTimestamp());
									model.setMediaId(doc.getId());
									model.setPath(path);
									messageRepository.save(model);
								}
								log.setId(messages.getId());
								log.setFrom(messages.getFrom());
								log.setStatus("Recived");
								log.setTime(messages.getTimestamp());
								log.setTo("Admin");
								logRepository.save(log);
							}else if(messages.getType().equals("image")) {
								WebhookModel model = new WebhookModel();
								WebhookLogModel log = new WebhookLogModel();
								WebhookHandleImage image = messages.getImage();
								String path = processing.extract(dataSourceProperties, image.getId(), messages.getFrom(), messages.getId(), "image");
								if(image.getCaption() !=null) {
									model.setCaption(image.getCaption());
									model.setId(messages.getId());
									model.setFrom(messages.getFrom());
									model.setType(messages.getType());
									model.setTime(messages.getTimestamp());
									model.setMediaId(image.getId());
									model.setPath(path);
									messageRepository.save(model);
								}else {
									model.setId(messages.getId());
									model.setFrom(messages.getFrom());
									model.setType(messages.getType());
									model.setTime(messages.getTimestamp());
									model.setMediaId(image.getId());
									model.setPath(path);
									messageRepository.save(model);
								}
								log.setId(messages.getId());
								log.setFrom(messages.getFrom());
								log.setStatus("Recived");
								log.setTime(messages.getTimestamp());
								log.setTo("Admin");
								logRepository.save(log);
							}
							Optional<WebhookLiveModel> olive = Optional.ofNullable(liveRepository.findByphone(messages.getFrom()));
							System.out.println(olive);
							if(olive.isEmpty()) {
								System.out.println("masuk empty");
								WebhookLiveModel live = new WebhookLiveModel();
								
								live.setPhone(messages.getFrom());
								live.setTimestamp(messages.getTimestamp());
								liveRepository.save(live);
							}else {
								WebhookLiveModel live = olive.get();
								live.setTimestamp(messages.getTimestamp());
								liveRepository.save(live);
							}
						}
						}
					}
				}
//			System.out.println("dari mainjson" + mainJson.get("entry").toString());
			} 
			else {
			    WebhookHandleTemplate json = om.readValue(json1, WebhookHandleTemplate.class);
			    if (json.getObject() != null) {
			        if (json.getEntry() != null && !json.getEntry().isEmpty()) {
			            WebhookHandleTemplateChanges change = json.getEntry().get(0).getChanges().get(0);
			            WebhookHandleTemplateValue value = change.getValue();
			            List<TemplateStatuses> statusesL = value.getStatuses();
			            TemplateStatuses statuses = statusesL.get(0);

			            String messageId = statuses.getId();
			            System.out.println(messageId);

			            Optional<WebhookModel> optionalModel = messageRepository.findById(messageId);

			            if (optionalModel.isPresent()) {
			                WebhookModel model = optionalModel.get();
			                model.setTime(statuses.getTimestamp());
			                messageRepository.save(model);
			            } 
			        }
			    }
			}


			processing.triggerService();
//			JSONArray entryJsonArrays = new JSONArray(mainJson.get("entry").toString());
////			System.out.println(entryJsonArrays.length());
//			JSONObject entryJsonObject = new JSONObject(entryJsonArrays.get(0).toString());
////			System.out.println(entyJsonObject);
//			JSONArray changesJsonArrays = new JSONArray(entryJsonObject.get("changes").toString());
////			System.out.println(changesJsonArrays.get(0));
//			JSONObject changesJsonObject = new JSONObject(changesJsonArrays.get(0).toString());
//			JSONObject valueJsonObject =new JSONObject(changesJsonObject.get("value").toString());
////			System.out.println(valueJsonObject.get("metadata"));
//			JSONArray  messagesJsonArrays = new JSONArray(valueJsonObject.get("messages").toString());
//			System.out.println(messagesJsonArrays.get(0));
		}
		
	    
}
