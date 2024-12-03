package be.storm.rulecrafterbackend.api.models.dtos.campaign;

import be.storm.rulecrafterbackend.api.models.forms.campaign.CampaignCreationBasicsForm;
import be.storm.rulecrafterbackend.bll.services.CampaignService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/campaignCreationBasic")
public class CampaignCreationBasicsController {

    private final CampaignService campaignService;

    @PostMapping
    public ResponseEntity<Void> createCampaignBasic(
            @Valid @RequestBody CampaignCreationBasicsForm,
            BindingResult bindingResult
            ) {

        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            throw new ValidationException("Validation error " + errors);
        }


    }
}
