package be.storm.rulecrafterbackend.api.controllers;

import be.storm.rulecrafterbackend.api.models.dtos.campaign.*;
import be.storm.rulecrafterbackend.api.models.dtos.location.FactionDTO;
import be.storm.rulecrafterbackend.api.models.dtos.location.LocationDTO;
import be.storm.rulecrafterbackend.bll.services.CampaignService;
import be.storm.rulecrafterbackend.bll.services.FactionService;
import be.storm.rulecrafterbackend.bll.services.LocationService;
import be.storm.rulecrafterbackend.bll.services.impls.FactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/campaign")
@CrossOrigin("*")
public class CampaignController {

    private final CampaignService campaignService;
    private final LocationService locationService;
    private final FactionService factionService;

    @GetMapping
    public ResponseEntity<List<CampaignHomeDTO>> getCampaigns() {

        List<CampaignHomeDTO> campaigns = campaignService.findAll()
                .stream()
                .map(CampaignHomeDTO::fromCampaign)
                .toList();
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignOverviewDTO> getCampaign(@PathVariable Long id) {
        CampaignOverviewDTO dto = CampaignOverviewDTO.fromCampaign(campaignService.findById(id));
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}/worldOverview")
    public ResponseEntity<CampaignWorldOverviewDTO> getWorldOverview(@PathVariable Long id) {
        CampaignWorldOverviewDTO dto = CampaignWorldOverviewDTO.fromWorldOverview(campaignService.findById(id));
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}/worldOverview/mainMapOverview")
    public ResponseEntity<CampaignMainMapOverviewDTO> getMainMap(@PathVariable Long id) {
        CampaignMainMapOverviewDTO dto = CampaignMainMapOverviewDTO.fromCampaign(campaignService.findById(id));
        List<LocationDTO> locations = locationService.findByCampaignId(id).stream().map(LocationDTO::fromLocation).toList();
        dto.setLocations(locations);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}/worldOverview/faction")
    public ResponseEntity<CampaignFactionsOverviewDTO> getFactions(@PathVariable Long id) {
        CampaignFactionsOverviewDTO dto = CampaignFactionsOverviewDTO.fromCampaign(campaignService.findById(id));
        List<FactionDTO> factions = factionService.findByCampaignId(id).stream().map(FactionDTO::fromFaction).toList();
        dto.setFactions(factions);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}/worldOverview/region")
    public ResponseEntity<CampaignRegionOverviewDTO> getRegions(@PathVariable Long id) {
        CampaignRegionOverviewDTO dto = CampaignRegionOverviewDTO.fromCampaignRegion(campaignService.findByRegionId(id));
        return ResponseEntity.ok(dto);
    }
}
