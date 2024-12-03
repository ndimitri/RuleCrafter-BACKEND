package be.storm.rulecrafterbackend.dal;

import be.storm.rulecrafterbackend.dal.models.classResponse.DnDClassResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class DnDRepository {
  private final WebClient webClient;

  public DnDRepository(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://www.dnd5eapi.co/api").build();
  }

  public DnDClassResponse getClassResponse(String classTypeName) {
    return webClient.get()
        .uri("/classes/{className}", classTypeName)
        .retrieve()
        .bodyToMono(DnDClassResponse.class)
        .block();
  }




}
