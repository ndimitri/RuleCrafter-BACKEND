package be.storm.rulecrafterbackend.il.initializers;

import be.storm.rulecrafterbackend.dal.repositories.campaign.CampaignRepository;
import be.storm.rulecrafterbackend.dal.repositories.campaign.RegionRepository;
import be.storm.rulecrafterbackend.dl.entities.campaign.Campaign;
import be.storm.rulecrafterbackend.dl.entities.campaign.Location;
import be.storm.rulecrafterbackend.dl.entities.campaign.Region;
import be.storm.rulecrafterbackend.dal.character.CharacterRepository;
import be.storm.rulecrafterbackend.dl.entities.character.Character;
import be.storm.rulecrafterbackend.dl.entities.character.ClassLevel;
import be.storm.rulecrafterbackend.dl.entities.character.Description;
import be.storm.rulecrafterbackend.dl.entities.character.Feat;
import be.storm.rulecrafterbackend.dl.entities.character.Item;
import be.storm.rulecrafterbackend.dl.entities.character.Price;
import be.storm.rulecrafterbackend.dl.entities.character.Proficiency;
import be.storm.rulecrafterbackend.dl.entities.character.SavingThrow;
import be.storm.rulecrafterbackend.dl.entities.character.Spell;
import be.storm.rulecrafterbackend.dl.entities.character.Stat;
import be.storm.rulecrafterbackend.dl.entities.enums.character.Alignment;
import be.storm.rulecrafterbackend.dl.entities.enums.character.ItemRarity;
import be.storm.rulecrafterbackend.dl.entities.enums.character.ItemType;
import be.storm.rulecrafterbackend.dl.entities.enums.character.MagicSchool;
import be.storm.rulecrafterbackend.dl.entities.enums.character.SpellLevel;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CampaignRepository campaignRepository;
    private final RegionRepository regionRepository;
    private final CharacterRepository characterRepository;

    @Override
    public void run(String... args) throws Exception {

        if(campaignRepository.count() == 0) {

            Region region = new Region(
                    "Aldenyr",
                    "The campaign is set in the region of Aldenyr, a diverse and ancient land filled with intrigue and peril.",
                    "Rule_crafter_12.jpg"
            );
            regionRepository.save(region);


            List<Campaign> campaigns = List.of(
                    new Campaign(
                            "Les Ruines de l'Éclipse Sombre",
                            "Un ancien temple oublié refait surface dans les montagnes maudites, coïncidant avec une éclipse " +
                                    "rare. Les érudits prétendent que le temple abrite un artefact capable de plonger le monde " +
                                    "dans une nuit éternelle. Les héros doivent explorer ces ruines, déjouer des énigmes " +
                                    "complexes, et affronter des cultistes déterminés à éveiller un dieu oublié. Mais la " +
                                    "malédiction du temple altère leurs esprits, les forçant à faire face à leurs propres " +
                                    "ténèbres intérieures.",
                            2,
                            4,
                            "Besoin d'un mage",
                            "Rule_crafter_1.jpg",
                            "Rule_crafter_2.jpg",
                            "Rule_crafter_3.jpg",
                            "Rule_crafter_4.jpg",
                            "Rule_crafter_5.jpg",
                            "Rule_crafter_6.jpg",
                            "Rule_crafter_7.jpg",
                            "Rule_crafter_8.jpg",
                            region
                    ),
                    new Campaign(
                            "Le Pacte des Mers Brisées",
                            "Des navires disparaissent dans une région maritime entourée de légendes. On parle d'un ancien " +
                                    "pacte entre les dieux de la mer et un capitaine déchu, dont la flotte fantôme hanterait " +
                                    "encore les flots. Les héros, engagés pour enquêter, doivent naviguer à travers des " +
                                    "tempêtes magiques, des îles oubliées et des créatures marines pour briser la malédiction. " +
                                    "Leur quête les mènera à décider du destin de la mer elle-même.",
                            1,
                            3,
                            "Besoin d'un gros tank",
                            "Rule_crafter_1.jpg",
                            "Rule_crafter_2.jpg",
                            "Rule_crafter_3.jpg",
                            "Rule_crafter_4.jpg",
                            "Rule_crafter_5.jpg",
                            "Rule_crafter_6.jpg",
                            "Rule_crafter_7.jpg",
                            "Rule_crafter_8.jpg",
                            region
                    ),
                    new Campaign(
                            "Les Flammes de l’Empire Cendré",
                            "L’empire prospère d’Arcanis est en ruines après qu’un dragon ancestral a ravagé ses capitales. " +
                                    "Les héros, parmi les rares survivants, découvrent que ce n’est pas une simple attaque, " +
                                    "mais le prélude à une conspiration visant à ressusciter une ancienne dynastie draconique. " +
                                    "Armés de reliques des temps passés, ils doivent rassembler les derniers bastions de " +
                                    "résistance et défier les conspirateurs avant que le monde ne soit consumé par le feu.",
                            1,
                            5,
                            "Besoin d'un voleur",
                            "Rule_crafter_1.jpg",
                            "Rule_crafter_2.jpg",
                            "Rule_crafter_3.jpg",
                            "Rule_crafter_4.jpg",
                            "Rule_crafter_5.jpg",
                            "Rule_crafter_6.jpg",
                            "Rule_crafter_7.jpg",
                            "Rule_crafter_8.jpg",
                            region
                    ),
                    new Campaign(
                            "Le Requiem du Dieu Brisé",
                            "Des rumeurs circulent sur un fragment d’un dieu déchu qui aurait atterri dans une vallée isolée. " +
                                    "Ce fragment émet une énergie corruptrice, transformant les habitants en monstres et " +
                                    "faisant apparaître des phénomènes inexplicables. Les héros sont recrutés par une mystérieuse " +
                                    "organisation pour récupérer le fragment, mais ils découvrent que d’autres factions – " +
                                    "certains dévoués à la résurrection du dieu – convoitent également cette relique divine.",
                            3,
                            6,
                            "Besoin d'un barde",
                            "Rule_crafter_1.jpg",
                            "Rule_crafter_2.jpg",
                            "Rule_crafter_3.jpg",
                            "Rule_crafter_4.jpg",
                            "Rule_crafter_5.jpg",
                            "Rule_crafter_6.jpg",
                            "Rule_crafter_7.jpg",
                            "Rule_crafter_8.jpg",
                            region
                    ),
                    new Campaign(
                            "La Chute des Étoiles d’Argent",
                            "Une pluie d’étoiles filantes s’abat sur le royaume de Lysara, laissant derrière elle des cristaux " +
                                    "scintillants. Mais ces cristaux ne sont pas que des merveilles : ils éveillent des portails " +
                                    "vers d’autres dimensions, libérant des créatures d’outre-monde. Les héros doivent enquêter " +
                                    "sur l’origine des étoiles et voyager entre les plans pour sceller les portails avant que " +
                                    "la réalité ne soit déchirée par une invasion cosmique.",
                            1,
                            2,
                            "Besoin d'une team full stuff",
                            "Rule_crafter_1.jpg",
                            "Rule_crafter_2.jpg",
                            "Rule_crafter_3.jpg",
                            "Rule_crafter_4.jpg",
                            "Rule_crafter_5.jpg",
                            "Rule_crafter_6.jpg",
                            "Rule_crafter_7.jpg",
                            "Rule_crafter_8.jpg",
                            region
                    ),
                    new Campaign(
                            "Les Ombres de l’Arche Interdite",
                            "Une arche massive, enveloppée dans des ombres surnaturelles, apparaît soudainement dans une grande " +
                                    "ville. Personne ne peut la franchir sans disparaître, mais les rumeurs parlent de trésors " +
                                    "inestimables et d'une puissance oubliée derrière ses portes. Les héros reçoivent une " +
                                    "invitation d’un mystérieux mécène pour explorer l’arche, mais ils découvrent rapidement " +
                                    "que l’intérieur défie les lois de la réalité. Chaque salle est un défi qui les rapproche " +
                                    "d’une entité qui rêve de remodeler le monde à son image.",
                            3,
                            5,
                            "Besoin de rien envie de toiiiiiii",
                            "Rule_crafter_1.jpg",
                            "Rule_crafter_2.jpg",
                            "Rule_crafter_3.jpg",
                            "Rule_crafter_4.jpg",
                            "Rule_crafter_5.jpg",
                            "Rule_crafter_6.jpg",
                            "Rule_crafter_7.jpg",
                            "Rule_crafter_8.jpg",
                            region
                    )
            );
            campaignRepository.saveAll(campaigns);

            List<Location> locations = List.of(
                    new Location(
                            "Main Map",
                            "The campaign is set in the region of Aldenyr, a diverse and ancient land filled" +
                                    "with intrigue and peril.",
                            "picture"
                    ),
                    new Location(
                            "Eldara (City of Shadows)",
                            "A sprawling metropolis where the campaign begins. Known for its towering black spires and shadowy " +
                                    "underbelly, it serves as both a hub of commerce and a battleground of political factions.",
                            "picture"
                    ),
                    new Location(
                            "The Umbral Forest",
                            "A cursed woodland teeming with shadow creatures and strange flora. Few who venture here return unscathed.",
                            "picture"
                    ),
                    new Location(
                            "The Temple of Radiance",
                            "An ancient shrine on a mountaintop, rumored to be the source of light that once vanquished the Umbral King.",
                            "picture"
                    ),
                    new Location(
                            "The Blackened Mire",
                            " A treacherous swamp where undead and fiends are said to dwell, protecting ancient secrets.",
                            "picture"
                    )
            );
            if (characterRepository.count() == 0) {

                //Création Character 1

                Character nike = new Character();
                nike.setName("Theo Bernardus");
                nike.setHp(15);
                nike.setRace("human");
                nike.setAlignment(Alignment.LAWFUL_GOOD);
                nike.setBackstory("Un membre de la secte X au carré");

                // Description
                Description description = new Description("24", "178cm", "70kg", "brown", "black", "brown");
                nike.setDescription(description);

                // Stats
                List<Stat> stats = List.of(
                        new Stat("strength", "str", 9),
                        new Stat("dexterity", "dex", 13),
                        new Stat("constitution", "con", 15),
                        new Stat("intelligence", "int", 7),
                        new Stat("wisdom", "wis", 4),
                        new Stat("charisma", "cha", 10)
                );
                nike.setStats(stats);

                // Feats
                List<Feat> feats = List.of(
                        new Feat("Brave", "You have advantage on saving throw against being frightened.", List.of())
                );
                nike.setFeats(feats);

                // Classes
                List<ClassLevel> classLevels = List.of(
                        new ClassLevel("barbarian", 1),
                        new ClassLevel("wizard", 1)
                );
                nike.setClasses(classLevels);

                // Saving Throws
                List<SavingThrow> savingThrows = List.of(
                        new SavingThrow("Strength", 2),
                        new SavingThrow("Dexterity", 0),
                        new SavingThrow("Constitution", 0),
                        new SavingThrow("Intelligence", 0),
                        new SavingThrow("Wisdom", 0),
                        new SavingThrow("Charisma", 0)
                );
                nike.setSavingThrows(savingThrows);

                // Proficiencies
                List<Proficiency> proficiencies = List.of(
                        new Proficiency("Acrobatics", 2, "dex"),
                        new Proficiency("Arcana", 3, "int"),
                        new Proficiency("Animal Handling", 1, "wis")
                );
                nike.setProficiencies(proficiencies);


                // Items
                List<Item> items = List.of(
                        new Item("Hiradia", "Hache ayant appartenu au dieu du caillou", "10kg", ItemRarity.LEGENDARY, ItemType.WEAPON, new Price(13, "gold"), List.of())
                );
                nike.setItems(items);

                //Spells
                List<Spell> spells = List.of(
                        new Spell("Déluge", SpellLevel.LEVEL_3, MagicSchool.NECROMANCY, "15s", "100m", "5min", "le plus grand champ de bataille morts", List.of())
                );
                nike.setSpells(spells);


                // Background
                nike.setBackground("Sage");

                // Sauvegarde
                characterRepository.save(nike);


                //Création Character 2

                Character character2 = new Character();
                character2.setName("Nikus Dimitrius");
                character2.setHp(20);
                character2.setRace("elf");
                character2.setAlignment(Alignment.NEUTRAL_EVIL);
                character2.setBackstory("Loup solitaire en quête d'aventure et de repoussement de ses limites. Il se balade à la recherche d'un maître au sommet de l'art de l'épée");

                // Description
                Description descriptionChar2 = new Description("24", "190cm", "85kg", "green", "white", "blond");
                character2.setDescription(descriptionChar2);

                // Stats
                List<Stat> statsChar2 = List.of(
                        new Stat("strength", "str", 15),
                        new Stat("dexterity", "dex", 14),
                        new Stat("constitution", "con", 15),
                        new Stat("intelligence", "int", 10),
                        new Stat("wisdom", "wis", 5),
                        new Stat("charisma", "cha", 12)
                );
                character2.setStats(statsChar2);

                // Feats
                List<Feat> featsChar2 = List.of(
                        new Feat("Elf Weapon Training", "You have proficiency with the longsword, shortsword, shortbow, and longbow.", List.of())
                );
                character2.setFeats(featsChar2);

                // Classes
                List<ClassLevel> classLevelsChar2 = List.of(
                        new ClassLevel("warlock", 1)
                );
                character2.setClasses(classLevelsChar2);

                // Saving Throws
                List<SavingThrow> savingThrowsChar2 = List.of(
                        new SavingThrow("Strength", 2),
                        new SavingThrow("Dexterity", 1),
                        new SavingThrow("Constitution", 1),
                        new SavingThrow("Intelligence", 0),
                        new SavingThrow("Wisdom", 0),
                        new SavingThrow("Charisma", 0)
                );
                character2.setSavingThrows(savingThrowsChar2);

                // Proficiencies
                List<Proficiency> proficienciesChar2 = List.of(
                        new Proficiency("Athletics", 3, "str"),
                        new Proficiency("Sleight of Hand", 1, "dex")
                );
                character2.setProficiencies(proficienciesChar2);


                // Items
                List<Item> itemsChar2 = List.of(
                        new Item("Lytta", "Epée aussi brillante que sanglante, aussi appelé 'Lame du sang'.", "2kg", ItemRarity.VERY_RARE, ItemType.WEAPON, new Price(15000, "gold"), List.of())
                );
                character2.setItems(itemsChar2);

                //Spells
                List<Spell> spellsChar2 = List.of(
                        new Spell("Wind Movement", SpellLevel.LEVEL_6, MagicSchool.ENCHANTMENT, "1s", "50m", "10s", "Englobe l'épée d'une fine couche de vent pouvant emporter des montagnes entières", List.of())
                );
                character2.setSpells(spellsChar2);


                // Background
                character2.setBackground("Ermite");

                characterRepository.save(character2);
            }
        }
    }
}
