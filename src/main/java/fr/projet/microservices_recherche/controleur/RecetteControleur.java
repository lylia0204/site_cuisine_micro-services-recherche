package fr.projet.microservices_recherche.controleur;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import fr.projet.microservices_recherche.model.Recette;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RequestMapping(path="/recette-api")
@RestController
public class RecetteControleur {

	
	

	//private WebClient client = WebClient.create("http://ec2-15-188-99-8.eu-west-3.compute.amazonaws.com");
	private WebClient client = WebClient.create(System.getenv("node_api_url"));
	//private WebClient client = WebClient.create("http://ec2-35-181-9-246.eu-west-3.compute.amazonaws.com:8888");
	
	

@GetMapping(path = "/public/recettes")  
private Flux<Recette> getAllRecettes() throws FileNotFoundException, UnsupportedEncodingException{ 
	PrintWriter writer = new PrintWriter("/tmp/the-file-name.txt", "UTF-8");
	writer.println("The first line");
	writer.println(System.getenv("node_api_url"));
	writer.println("The third line");
	writer.println(System.getenv("NODE_API_URL"));
	writer.println("The third line");
	writer.close();
	return client.get()
			.uri("/recette-api/public/recettes")
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.bodyToFlux(Recette.class)
			.log("dans get all*********************");
}

@GetMapping("public/recette/{_id}")
public Mono<Recette>getEventById(@PathVariable("_id") String _id) {
	System.out.println(" Connection to Spring BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOT");
	return client.get().uri("/recette-api/public/recette/{_id}", _id)
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.bodyToMono(Recette.class)
			.log("*************************dans get id");	
}

@RequestMapping(value = "public/recette")
public Flux<Recette>getRecetteByTypeRecette(@RequestParam(required = false) String cat_){
	
	return client.get().uri("/recette-api/public/recette?cat_="+ cat_)
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.bodyToFlux(Recette.class)
			.log();	
}



}
	
	
	//private WebClient client; //= WebClient.create("http://localhost:3000");
	
	
//	public EventService(WebClient.Builder webClientBuilder) {
//		this.client = webClientBuilder.baseUrl("http://localhost:3000").build();
//	}
	
	
//	@GetMapping(path="public/events")
//	public Flux<Recette> getEvents(){
//		return client.get()
//				.uri("/event-api/public/events")
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.bodyToFlux(Event.class)
//				.log("heyy$*****");
//	}
//	
//	
//	
//	
//	@PostMapping("private/event")
//	public Mono<Event>createEvent(@RequestBody Event event){
//		return client.post().uri("/event-api/private/event")
//				.accept(MediaType.APPLICATION_JSON)
//				.body(BodyInserters.fromObject(event))
//				.retrieve()
//				.bodyToMono(Event.class)
//				.log("********hey CREATE ************");	
//	}
//	
//	@PutMapping ("private/admin/event")
//	public Mono<Event> updateEvent(@RequestBody Event event){
//		return client.put().uri("event-api/private/role-admin/updateEvent")
//				.accept(MediaType.APPLICATION_JSON)
//				.syncBody(event)
//				.retrieve()
//				.bodyToMono(Event.class)
//				.log("**Hey   UPDATE***********");
//	}
//	
//	@RequestMapping(value = "public/event", params = "country" )
//	public Flux<Event>getEventByCountry(@RequestParam String country){
//		System.out.println("DANS COUNTRY !!!!");
//		return client.get().uri("/event-api/public/event?country="+country)
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.bodyToFlux(Event.class)
//				.log("********COUUNTTRYY************");	
//	}
//	
//	@RequestMapping(value = "public/event", params = "city" )
//	public Flux<Event>getEventByCity(@RequestParam String city){
//		System.out.println("DANS COUNTRY !!!!");
//		return client.get().uri("/event-api/public/event?city="+city)
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.bodyToFlux(Event.class)
//				.log("********CCCIIIITTTYYYYY************");	
//	}
//	
//	@RequestMapping(value = "public/event")
//	public Flux<Event>getEventByKeyWord(@RequestParam String research){
//		System.out.println("DANS COUNTRY !!!!");
//		return client.get().uri("/event-api/public/search?research="+research)
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.bodyToFlux(Event.class)
//				.log("********KEY******WORD************");	
//	}
//	
//	@DeleteMapping("private/admin/event/{_id}")
//	public Mono<Event> deleteEvent(@PathVariable("_id") String _id){
//		return client.delete().uri("/event-api/private/role-admin/deleteEvent/{_id}", _id)
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.bodyToMono(Event.class)
//				.log("**Hey   DELETE***********" + _id);
//	}
//	
	


