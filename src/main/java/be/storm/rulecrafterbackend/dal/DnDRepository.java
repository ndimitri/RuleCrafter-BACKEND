package be.storm.rulecrafterbackend.dal;

import be.storm.rulecrafterbackend.dal.models.classResponse.DnDClassResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class DnDRepository {
  private final WebClient webClient;

  public DnDRepository(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://www.dnd5api.co/api").build();
  }

  public DnDClassResponse getClassResponse(String className) {
    return webClient.get()
        .uri("/classes/{className}", className)
        .retrieve()
        .bodyToMono(DnDClassResponse.class)
        .block();
  }

}
