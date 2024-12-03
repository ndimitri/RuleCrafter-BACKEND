INSERT INTO ability_stats (cha, con, dex, intel, str, wis, created_at, updated_at) VALUES
(8, 14, 12, 10, 16, 16, NOW(), NOW()),  -- ID généré automatiquement
(14, 12, 18, 14, 10, 12, NOW(), NOW()),
(20, 14, 10, 18, 8, 12, NOW(), NOW()),
(10, 16, 12, 10, 14, 14, NOW(), NOW()),
(12, 16, 14, 8, 18, 10, NOW(), NOW());



INSERT INTO character (hp, abilities_id, created_at, updated_at, alignment, class_type, name, race) VALUES
(45, 1, NOW(), NOW(), 'LAWFUL_GOOD', 'cleric', 'Tharion', 'human'),
(38, 2, NOW(), NOW(), 'NEUTRAL_TRUE', 'rogue', 'Elara', 'elf'),
(70, 3, NOW(), NOW(), 'CHAOTIC_EVIL', 'warlock', 'Mordekai', 'tiefling'),
(90, 4, NOW(), NOW(), 'LAWFUL_NEUTRAL', 'paladin', 'Lysandra', 'dwarf'),
(25, 5, NOW(), NOW(), 'CHAOTIC_NEUTRAL', 'barbarian', 'Fynbar', 'halfling');
