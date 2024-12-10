package be.storm.rulecrafterbackend.api.controllers;

import be.storm.rulecrafterbackend.api.models.dtos.campaign.CampaignHomeDTO;
import be.storm.rulecrafterbackend.bll.services.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/campaign")
@CrossOrigin("*")
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping
    public ResponseEntity<List<CampaignHomeDTO>> getCampaigns() {

        List<CampaignHomeDTO> campaigns = campaignService.findAll()
                .stream()
                .map(CampaignHomeDTO::fromCampaign)
                .toList();
        return ResponseEntity.ok(campaigns);
    }
}
