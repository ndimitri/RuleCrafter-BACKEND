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



                // Création Character 3
                Character lyra = new Character();
                lyra.setName("Lyra Moonshadow");
                lyra.setHp(12);
                lyra.setRace("elf");
                lyra.setAlignment(Alignment.CHAOTIC_GOOD);
                lyra.setBackstory("Gardienne des anciens secrets de la forêt d'Aetherea");

// Description
                Description descriptionLyra = new Description("120", "165cm", "55kg", "green", "silver", "pale");
                lyra.setDescription(descriptionLyra);

// Stats
                List<Stat> statsLyra = List.of(
                    new Stat("strength", "str", 8),
                    new Stat("dexterity", "dex", 15),
                    new Stat("constitution", "con", 10),
                    new Stat("intelligence", "int", 14),
                    new Stat("wisdom", "wis", 12),
                    new Stat("charisma", "cha", 13)
                );
                lyra.setStats(statsLyra);

// Feats
                List<Feat> featsLyra = List.of(
                    new Feat("Keen Senses", "You have proficiency in the Perception skill.", List.of()),
                    new Feat("Fey Ancestry", "Advantage on saving throws against being charmed.", List.of())
                );
                lyra.setFeats(featsLyra);

// Classes
                List<ClassLevel> classLevelsLyra = List.of(
                    new ClassLevel("ranger", 2)
                );
                lyra.setClasses(classLevelsLyra);

// Saving Throws
                List<SavingThrow> savingThrowsLyra = List.of(
                    new SavingThrow("Strength", 0),
                    new SavingThrow("Dexterity", 4),
                    new SavingThrow("Constitution", 1),
                    new SavingThrow("Intelligence", 2),
                    new SavingThrow("Wisdom", 3),
                    new SavingThrow("Charisma", 1)
                );
                lyra.setSavingThrows(savingThrowsLyra);

// Proficiencies
                List<Proficiency> proficienciesLyra = List.of(
                    new Proficiency("Nature", 4, "int"),
                    new Proficiency("Perception", 5, "wis"),
                    new Proficiency("Stealth", 4, "dex")
                );
                lyra.setProficiencies(proficienciesLyra);

// Items
                List<Item> itemsLyra = List.of(
                    new Item("Moonlit Bow", "Arc magique infusé par la lumière lunaire", "3kg", ItemRarity.RARE, ItemType.WEAPON, new Price(25, "gold"), List.of()),
                    new Item("Forest Cloak", "Cape dissimulant son porteur dans les ombres des bois", "1kg", ItemRarity.UNCOMMON, ItemType.ARMOR, new Price(15, "gold"), List.of())
                );
                lyra.setItems(itemsLyra);

// Spells
                List<Spell> spellsLyra = List.of(
                    new Spell("Entangle", SpellLevel.LEVEL_1, MagicSchool.CONJURATION, "1 action", "30m", "1 minute", "Vines sprout from the ground to restrain enemies.", List.of()),
                    new Spell("Hunter's Mark", SpellLevel.LEVEL_1, MagicSchool.DIVINATION, "1 bonus action", "90m", "1 hour", "Marks an enemy for increased damage.", List.of())
                );
                lyra.setSpells(spellsLyra);

// Background
                lyra.setBackground("Outlander");

// Sauvegarde
                characterRepository.save(lyra);

                //Character 4
                Character valdrak = new Character();
                valdrak.setName("Valdrak Ironfist");
                valdrak.setHp(18);
                valdrak.setRace("dwarf");
                valdrak.setAlignment(Alignment.LAWFUL_NEUTRAL);
                valdrak.setBackstory("Ancien capitaine de la garde des mines de Kharak'Zhul.");

// Description
                valdrak.setDescription(new Description("75", "140cm", "80kg", "blue", "red", "tan"));

// Stats
                valdrak.setStats(List.of(
                    new Stat("strength", "str", 16),
                    new Stat("dexterity", "dex", 10),
                    new Stat("constitution", "con", 18),
                    new Stat("intelligence", "int", 8),
                    new Stat("wisdom", "wis", 12),
                    new Stat("charisma", "cha", 9)
                ));

// Feats
                valdrak.setFeats(List.of(
                    new Feat("Stone Resilience", "Resistance to poison damage.", List.of()),
                    new Feat("Shield Master", "Adds shield AC to Dexterity saving throws.", List.of())
                ));

// Classes
                valdrak.setClasses(List.of(new ClassLevel("fighter", 3)));

// Saving Throws
                valdrak.setSavingThrows(List.of(
                    new SavingThrow("Strength", 5),
                    new SavingThrow("Dexterity", 1),
                    new SavingThrow("Constitution", 6)
                ));

// Proficiencies
                valdrak.setProficiencies(List.of(
                    new Proficiency("Athletics", 5, "str"),
                    new Proficiency("Survival", 3, "wis")
                ));

// Items
                valdrak.setItems(List.of(
                    new Item("Warhammer", "Martel lourd de guerre", "7kg", ItemRarity.UNCOMMON, ItemType.WEAPON, new Price(20, "gold"), List.of()
                )));

// Spells
                valdrak.setSpells(List.of());  // Aucun sort

// Background
                valdrak.setBackground("Soldier");

                characterRepository.save(valdrak);

                //Character 5
                Character elenya = new Character();
                elenya.setName("Elenya Faereth");
                elenya.setHp(8);
                elenya.setRace("elf");
                elenya.setAlignment(Alignment.CHAOTIC_NEUTRAL);
                elenya.setBackstory("Prêtresse errante d'une déesse oubliée.");

// Description
                elenya.setDescription(new Description("150", "165cm", "60kg", "green", "silver", "pale"));

// Stats
                elenya.setStats(List.of(
                    new Stat("strength", "str", 8),
                    new Stat("dexterity", "dex", 14),
                    new Stat("constitution", "con", 10),
                    new Stat("intelligence", "int", 17),
                    new Stat("wisdom", "wis", 12),
                    new Stat("charisma", "cha", 15)
                ));

// Feats
                elenya.setFeats(List.of(
                    new Feat("Mystic Vision", "See magical auras.", List.of()),
                    new Feat("Arcane Recovery", "Recover spell slots.", List.of())
                ));

// Classes
                elenya.setClasses(List.of(new ClassLevel("sorcerer", 3)));

// Saving Throws
                elenya.setSavingThrows(List.of(
                    new SavingThrow("Intelligence", 5),
                    new SavingThrow("Charisma", 4)
                ));

// Proficiencies
                elenya.setProficiencies(List.of(
                    new Proficiency("Arcana", 5, "int"),
                    new Proficiency("Persuasion", 4, "cha")
                ));

// Items
                elenya.setItems(List.of(
                    new Item("Staff of the Moon", "Bâton magique mystique", "4kg", ItemRarity.RARE, ItemType.WEAPON, new Price(50, "gold"), List.of())
                ));

// Spells
                elenya.setSpells(List.of(
                    new Spell("Magic Missile", SpellLevel.LEVEL_1, MagicSchool.EVOCATION, "1 action", "120m", "instant", "Bolts of magical force.", List.of()),
                    new Spell("Charm Person", SpellLevel.LEVEL_1, MagicSchool.ENCHANTMENT, "1 action", "9m", "1 hour", "Charm an enemy.", List.of())
                ));

// Background
                elenya.setBackground("Hermit");

                characterRepository.save(elenya);

                //Character 6
                Character kaelen = new Character();
                kaelen.setName("Kaelen Thorne");
                kaelen.setHp(12);
                kaelen.setRace("human");
                kaelen.setAlignment(Alignment.CHAOTIC_NEUTRAL);
                kaelen.setBackstory("Ancien espion de la guilde des Ombres, il cherche à échapper à son passé.");

// Description
                kaelen.setDescription(new Description("28", "180cm", "75kg", "gray", "black", "pale"));

// Stats
                kaelen.setStats(List.of(
                    new Stat("strength", "str", 10),
                    new Stat("dexterity", "dex", 17),
                    new Stat("constitution", "con", 12),
                    new Stat("intelligence", "int", 13),
                    new Stat("wisdom", "wis", 10),
                    new Stat("charisma", "cha", 14)
                ));

// Feats
                kaelen.setFeats(List.of(
                    new Feat("Sneak Attack", "Deal extra damage when attacking with advantage.", List.of()),
                    new Feat("Cunning Action", "Take a bonus action to dash, disengage, or hide.", List.of())
                ));

// Classes
                kaelen.setClasses(List.of(new ClassLevel("rogue", 3)));

// Saving Throws
                kaelen.setSavingThrows(List.of(
                    new SavingThrow("Dexterity", 5),
                    new SavingThrow("Intelligence", 3)
                ));

// Proficiencies
                kaelen.setProficiencies(List.of(
                    new Proficiency("Stealth", 6, "dex"),
                    new Proficiency("Sleight of Hand", 5, "dex"),
                    new Proficiency("Deception", 4, "cha")
                ));

// Items
                kaelen.setItems(List.of(
                    new Item("Shadow Cloak", "Cloak that blends with darkness.", "3kg", ItemRarity.RARE, ItemType.ARMOR, new Price(60, "gold"), List.of()),
                    new Item("Dagger of Silence", "Enchanted dagger that silences its victim.", "1kg", ItemRarity.UNCOMMON, ItemType.WEAPON, new Price(40, "gold"), List.of())
                ));

// Spells
                kaelen.setSpells(List.of());  // Aucun sort

// Background
                kaelen.setBackground("Spy");

                characterRepository.save(kaelen);


                //Character 7
                Character myra = new Character();
                myra.setName("Myra Dawnsworn");
                myra.setHp(20);
                myra.setRace("human");
                myra.setAlignment(Alignment.LAWFUL_GOOD);
                myra.setBackstory("Bénie par le dieu de la lumière, elle combat les ténèbres et défend les opprimés.");

// Description
                myra.setDescription(new Description("32", "175cm", "70kg", "blue", "blonde", "fair"));

// Stats
                myra.setStats(List.of(
                    new Stat("strength", "str", 16),
                    new Stat("dexterity", "dex", 11),
                    new Stat("constitution", "con", 14),
                    new Stat("intelligence", "int", 10),
                    new Stat("wisdom", "wis", 13),
                    new Stat("charisma", "cha", 15)
                ));

// Feats
                myra.setFeats(List.of(
                    new Feat("Divine Smite", "Add radiant damage to weapon attacks.", List.of()),
                    new Feat("Lay on Hands", "Heal wounds with divine energy.", List.of())
                ));

// Classes
                myra.setClasses(List.of(new ClassLevel("paladin", 3)));

// Saving Throws
                myra.setSavingThrows(List.of(
                    new SavingThrow("Wisdom", 4),
                    new SavingThrow("Charisma", 5)
                ));

// Proficiencies
                myra.setProficiencies(List.of(
                    new Proficiency("Persuasion", 5, "cha"),
                    new Proficiency("Insight", 4, "wis"),
                    new Proficiency("Athletics", 4, "str")
                ));

// Items
                myra.setItems(List.of(
                    new Item("Dawnblade", "Holy sword blessed by the light.", "4kg", ItemRarity.LEGENDARY, ItemType.WEAPON, new Price(100, "gold"), List.of()),
                    new Item("Aegis Shield", "Magically enchanted shield.", "5kg", ItemRarity.RARE, ItemType.ARMOR, new Price(75, "gold"), List.of())
                ));

// Spells
                myra.setSpells(List.of(
                    new Spell("Bless", SpellLevel.LEVEL_1, MagicSchool.ENCHANTMENT, "1 action", "30ft", "1min", "Add bonuses to allies' attacks.", List.of()),
                    new Spell("Cure Wounds", SpellLevel.LEVEL_1, MagicSchool.EVOCATION, "1 action", "Touch", "instant", "Heal an ally's wounds.", List.of())
                ));

// Background
                myra.setBackground("Knight");

                characterRepository.save(myra);



            }
        }
    }
}
