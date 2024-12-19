package be.storm.rulecrafterbackend.api.controllers.campaign;

import be.storm.rulecrafterbackend.api.models.dtos.campaign.*;
import be.storm.rulecrafterbackend.api.models.dtos.location.FactionDTO;
import be.storm.rulecrafterbackend.api.models.dtos.location.LocationDTO;
import be.storm.rulecrafterbackend.api.models.forms.campaign.*;
import be.storm.rulecrafterbackend.bll.services.campaign.*;
import be.storm.rulecrafterbackend.dl.entities.campaign.*;
import be.storm.rulecrafterbackend.dl.entities.npcs.Npc;
import be.storm.rulecrafterbackend.dl.entities.quest.MainQuest;
import be.storm.rulecrafterbackend.dl.entities.quest.SideQuest;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    private final RegionService regionService;
    private final NpcService npcService;
    private final MainQuestService mainQuestService;
    private final SideQuestService sideQuestService;
    private final ScenarioService scenarioService;


    //region CAMPAIGN_OVERVIEW

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
        CampaignRegionOverviewDTO dto = CampaignRegionOverviewDTO.fromCampaignRegion(campaignService.findByCampaignId(id));
        return ResponseEntity.ok(dto);
    }

    //endregion

    //region CAMPAIGN_BASICS_CREATION

    @PostMapping("/campaignCreation/basicsInfo")
    public ResponseEntity<Void> createCampaignBasicInfos(
            @Valid @RequestBody CampaignBasicsInfoCreationForm campaignBasicsInfoForm,
            BindingResult bindingResult
            ) {

        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            throw new ValidationException("Validation Error : " + errors);
        }

        Campaign campaign = campaignBasicsInfoForm.toCampaignBasicsInfo();
        campaignService.save(campaign);

        return ResponseEntity.noContent().build();
    }

    //endregion

    //region CAMPAIGN_WORLD_BUILDING

    @PostMapping("/campaignCreation/region")
    public ResponseEntity<Void> createCampaignRegion(
            @Valid @RequestBody CampaignRegionCreationForm campaignRegionCreationForm,
            BindingResult bindingResult
            ) {

        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            throw new ValidationException("Validation Error : " + errors);
        }

        Region region = campaignRegionCreationForm.toCampaignRegionCreation();
        regionService.save(region);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/campaignCreation/location")
    public ResponseEntity<Void> createCampaignLocation(
            @Valid @RequestBody CampaignLocationCreationForm campaignLocationCreationForm,
            BindingResult bindingResult
            ) {

        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            throw new ValidationException("Validation Error : " + errors);
        }

        Location location = campaignLocationCreationForm.toCampaignLocationCreationForm();
        locationService.save(location);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/campaignCreation/faction")
    public ResponseEntity<Void> createCampaignFaction(
            @Valid @RequestBody CampaignFactionCreationForm campaignFactionCreationForm,
            BindingResult bindingResult
            ) {

        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            throw new ValidationException("Validation Error : " + errors);
        }

        Faction faction = campaignFactionCreationForm.toCampaignFactionCreationForm();
        factionService.save(faction);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/campaignCreation/npc")
    public  ResponseEntity<Void> createCampaignNpc(
            @Valid @RequestBody CampaignNpcCreationForm campaignNpcCreationForm,
            BindingResult bindingResult
            ) {

        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            throw new ValidationException("Validation Error : " + errors);
        }

        Npc npc = campaignNpcCreationForm.toCampaignNpcCreationForm();
        npcService.save(npc);

        return ResponseEntity.noContent().build();
    }

    //endregion

    //region CAMPAIGN_QUEST_CREATION

    @PostMapping("/campaignCreation/mainQuest")
    public ResponseEntity<Void> createCmapaignMainQuest(
            @Valid @RequestBody CampaignMainQuestCreationForm campaignMainQuestCreationForm,
            BindingResult bindingResult
    ) {

        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            throw new ValidationException("Validation Error : " + errors);
        }

        MainQuest mainQuest = campaignMainQuestCreationForm.toCampaignMainQuestCreationForm();
        mainQuestService.save(mainQuest);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/campaignCreation/sideQuest")
    public ResponseEntity<Void> createCampaignSideQuest(
            @Valid @RequestBody CampaignSideQuestCreationForm campaignSideQuestCreationForm,
            BindingResult bindingResult
    ) {

        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            throw new ValidationException("Validation Error : " + errors);
        }

        SideQuest sideQuest = campaignSideQuestCreationForm.toCampaignSideQuestCreationForm();
        sideQuestService.save(sideQuest);

        return ResponseEntity.noContent().build();
    }

    //endregion

    //region CAMPAIGN_SCENARIO_CREATION

    @PostMapping("/campaignCreation/scenario")
    public ResponseEntity<Void> createCampaignScenario(
            @Valid @RequestBody CampaignScenarioCreationForm campaignScenarioCreationForm,
            BindingResult bindingResult
    ) {

        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            throw new ValidationException("Validation Error : " + errors);
        }

        Scenario scenario = campaignScenarioCreationForm.toCampaignScenarioCreationForm();
        scenarioService.save(scenario);

        return ResponseEntity.noContent().build();
    }

    //endregion

//    @PostMapping("/campaignCreation/campaignContainer")
//    public ResponseEntity<Void> createCampaignContainer(
//            @Valid @RequestBody CampaignCreationAssemblingForm campaignCreationAssemblingForm
//    ) {
//
//        campaignCreationAssemblingForm.toCampaignCreationAssemblingForm();
//        campaignInfoContainerService.save(campaignInfoContainer);
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/campaignCreation/campaignContainer")
//    public ResponseEntity<List<CampaignCreationAssemblingDTO>> getCampaignCreationAssembling() {
//        List<CampaignCreationAssemblingDTO> campaigns = campaignInfoContainerService.findAll()
//                .stream()
//                .map(CampaignCreationAssemblingDTO::fromCampaignCreationAssemblingDTO)
//                .toList();
//        return ResponseEntity.ok(campaigns);
//    }
}
