package be.storm.rulecrafterbackend.il.initializers;

import be.storm.rulecrafterbackend.dal.repositories.campaign.CampaignRepository;
import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CampaignRepository campaignRepository;

    @Override
    public void run(String... args) throws Exception {

        if(campaignRepository.count() == 0) {

            List<Campaign> campaigns = List.of(
                    new Campaign(
                            1L,
                            "Les Ruines de l'Éclipse Sombre",
                            "Un ancien temple oublié refait surface dans les montagnes maudites, coïncidant avec une éclipse " +
                                    "rare. Les érudits prétendent que le temple abrite un artefact capable de plonger le monde " +
                                    "dans une nuit éternelle. Les héros doivent explorer ces ruines, déjouer des énigmes " +
                                    "complexes, et affronter des cultistes déterminés à éveiller un dieu oublié. Mais la " +
                                    "malédiction du temple altère leurs esprits, les forçant à faire face à leurs propres " +
                                    "ténèbres intérieures.",
                            2,
                            4
                    ),
                    new Campaign(
                            2L,
                            "Le Pacte des Mers Brisées",
                            "Des navires disparaissent dans une région maritime entourée de légendes. On parle d'un ancien " +
                                    "pacte entre les dieux de la mer et un capitaine déchu, dont la flotte fantôme hanterait " +
                                    "encore les flots. Les héros, engagés pour enquêter, doivent naviguer à travers des " +
                                    "tempêtes magiques, des îles oubliées et des créatures marines pour briser la malédiction. " +
                                    "Leur quête les mènera à décider du destin de la mer elle-même.",
                            1,
                            3
                    ),
                    new Campaign(
                            3L,
                            "Les Flammes de l’Empire Cendré",
                            "L’empire prospère d’Arcanis est en ruines après qu’un dragon ancestral a ravagé ses capitales. " +
                                    "Les héros, parmi les rares survivants, découvrent que ce n’est pas une simple attaque, " +
                                    "mais le prélude à une conspiration visant à ressusciter une ancienne dynastie draconique. " +
                                    "Armés de reliques des temps passés, ils doivent rassembler les derniers bastions de " +
                                    "résistance et défier les conspirateurs avant que le monde ne soit consumé par le feu.",
                            1,
                            5
                    ),
                    new Campaign(
                            4L,
                            "Le Requiem du Dieu Brisé",
                            "Des rumeurs circulent sur un fragment d’un dieu déchu qui aurait atterri dans une vallée isolée. " +
                                    "Ce fragment émet une énergie corruptrice, transformant les habitants en monstres et " +
                                    "faisant apparaître des phénomènes inexplicables. Les héros sont recrutés par une mystérieuse " +
                                    "organisation pour récupérer le fragment, mais ils découvrent que d’autres factions – " +
                                    "certains dévoués à la résurrection du dieu – convoitent également cette relique divine.",
                            3,
                            6
                    ),
                    new Campaign(
                            5L,
                            "La Chute des Étoiles d’Argent",
                            "Une pluie d’étoiles filantes s’abat sur le royaume de Lysara, laissant derrière elle des cristaux " +
                                    "scintillants. Mais ces cristaux ne sont pas que des merveilles : ils éveillent des portails " +
                                    "vers d’autres dimensions, libérant des créatures d’outre-monde. Les héros doivent enquêter " +
                                    "sur l’origine des étoiles et voyager entre les plans pour sceller les portails avant que " +
                                    "la réalité ne soit déchirée par une invasion cosmique.",
                            1,
                            2
                    ),
                    new Campaign(
                            6L,
                            "Les Ombres de l’Arche Interdite",
                            "Une arche massive, enveloppée dans des ombres surnaturelles, apparaît soudainement dans une grande " +
                                    "ville. Personne ne peut la franchir sans disparaître, mais les rumeurs parlent de trésors " +
                                    "inestimables et d'une puissance oubliée derrière ses portes. Les héros reçoivent une " +
                                    "invitation d’un mystérieux mécène pour explorer l’arche, mais ils découvrent rapidement " +
                                    "que l’intérieur défie les lois de la réalité. Chaque salle est un défi qui les rapproche " +
                                    "d’une entité qui rêve de remodeler le monde à son image.",
                            3,
                            5
                    )
            );
            campaignRepository.saveAll(campaigns);
        }
    }
}
