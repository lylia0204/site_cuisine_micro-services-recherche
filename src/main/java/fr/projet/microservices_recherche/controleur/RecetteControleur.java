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

	
	

	
	private WebClient client = WebClient.create(System.getenv("NODE_API_URL"));
	
	

@GetMapping(path = "/public/recettes")  
private Flux<Recette> getAllRecettes() { 
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



@RequestMapping(value = "public/searchrecette")
public Flux<Recette> getRecetteByNomRecette(@RequestParam(required = false) String search) {
	
	return client.get().uri("/recette-api/public/searchrecette?search=" + search).accept(MediaType.APPLICATION_JSON)
			.retrieve().bodyToFlux(Recette.class).log("cherche bu name heeeeeeeeeeeeeeeeeey");
}





@RequestMapping(value = "public/searchin")
public Flux<Recette> getRecetteByIngrRecette(@RequestParam(required = false) String in1, String in2, String in3) {
	
	
	
	
	
	if(in1 == null && in2 == null ) {
		return client.get().uri("/recette-api/public/searchin?in3="+in3).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("in1= " + in1 + "  in2 = "+in2 +"  in3 = "+in3);
	}
	
	if(in2 == null && in3 == null) {
		return client.get().uri("/recette-api/public/searchin?in1="+in1).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("in1= " + in1 + "  in2 = "+in2 +"  in3 = "+in3);
	}
	
	if(in1 == null && in3 == null ) {
		return client.get().uri("/recette-api/public/searchin?in2="+in2).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("in1= " + in1 + "  in2 = "+in2 +"  in3 = "+in3);
	}
	
	if(in1 == null ) {
		return client.get().uri("/recette-api/public/searchin?in2="+in2+"&in3="+in3).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("in1= " + in1 + "  in2 = "+in2 +"  in3 = "+in3);
	}
	
	if(in2 == null ) {
		return client.get().uri("/recette-api/public/searchin?in1="+in1+"&in3="+in3).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("in1= " + in1 + "  in2 = "+in2 +"  in3 = "+in3);
	}
	
	if(in3 == null ) {
		return client.get().uri("/recette-api/public/searchin?in1="+in1+"&in2="+in2).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("in1= " + in1 + "  in2 = "+in2 +"  in3 = "+in3);
	}
	
	return client.get().uri("/recette-api/public/searchin?in1="+in1+"&in2="+in2+"&in3="+in3).accept(MediaType.APPLICATION_JSON)
			.retrieve().bodyToFlux(Recette.class).log("in1= " + in1 + "  in2 = "+in2 +"  in3 = "+in3);
}

@RequestMapping(value = "public/searchas")
public Flux<Recette> getRecetteAvecSansIngredient(@RequestParam(required = false) String rqt, String avec, String sans) {
	
	
	
	
	
	if(rqt == null && avec == null ) {
		return client.get().uri("/recette-api/public/searchas?sans="+sans).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("rqt= " + rqt + "  avec = "+avec +"  sans = "+sans);
	}
	
	if(avec == null && sans == null) {
		return client.get().uri("/recette-api/public/searchas?rqt="+rqt).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("rqt= " + rqt + "  avec = "+avec +"  sans = "+sans);
	}
	
	if(rqt == null && sans == null ) {
		return client.get().uri("/recette-api/public/searchas?avec="+avec).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("rqt= " + rqt + "  avec = "+avec +"  sans = "+sans);
	}
	
	if(rqt == null ) {
		return client.get().uri("/recette-api/public/searchas?avec="+avec+"&sans="+sans).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("rqt= " + rqt + "  avec = "+avec +"  sans = "+sans);
	}
	
	if(avec == null ) {
		return client.get().uri("/recette-api/public/searchas?rqt="+rqt+"&sans="+sans).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("rqt= " + rqt + "  avec = "+avec +"  sans = "+sans);
	}
	
	if(sans == null ) {
		return client.get().uri("/recette-api/public/searchas?rqt="+rqt+"&avec="+avec).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(Recette.class).log("rqt= " + rqt + "  avec = "+avec +"  sans = "+sans);
	}
	
	return client.get().uri("/recette-api/public/searchas?rqt="+rqt+"&avec="+avec+"&sans="+sans).accept(MediaType.APPLICATION_JSON)
			.retrieve().bodyToFlux(Recette.class).log("rqt= " + rqt + "  avec = "+avec +"  sans = "+sans);
}


}
	
	


