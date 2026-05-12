-- Seed data for Categories, Locations, Professionals
-- IDs are explicit so relations can be inserted deterministically.
-- If your JPA/Hibernate naming strategy differs, you may need to adjust
-- the join table name (`professional_categories`) or column names.

-- 7 Categories
INSERT INTO category (id, name) VALUES (1, 'Pintor');
INSERT INTO category (id, name) VALUES (2, 'Babá');
INSERT INTO category (id, name) VALUES (3, 'Cuidador de idoso');
INSERT INTO category (id, name) VALUES (4, 'Encanador');
INSERT INTO category (id, name) VALUES (5, 'Eletricista');
INSERT INTO category (id, name) VALUES (6, 'Jardineiro');
INSERT INTO category (id, name) VALUES (7, 'Limpeza doméstica');

-- 10 Locations
INSERT INTO location (id, state, city, neighborhood) VALUES (1, 'SP', 'São Paulo', 'Jardins');
INSERT INTO location (id, state, city, neighborhood) VALUES (2, 'SP', 'São Paulo', 'Pinheiros');
INSERT INTO location (id, state, city, neighborhood) VALUES (3, 'SP', 'Guarulhos', 'Centro');
INSERT INTO location (id, state, city, neighborhood) VALUES (4, 'RJ', 'Rio de Janeiro', 'Copacabana');
INSERT INTO location (id, state, city, neighborhood) VALUES (5, 'RJ', 'Niterói', 'Icaraí');
INSERT INTO location (id, state, city, neighborhood) VALUES (6, 'MG', 'Belo Horizonte', 'Savassi');
INSERT INTO location (id, state, city, neighborhood) VALUES (7, 'PR', 'Curitiba', 'Batel');
INSERT INTO location (id, state, city, neighborhood) VALUES (8, 'RS', 'Porto Alegre', 'Moinhos de Vento');
INSERT INTO location (id, state, city, neighborhood) VALUES (9, 'BA', 'Salvador', 'Barra');
INSERT INTO location (id, state, city, neighborhood) VALUES (10, 'PE', 'Recife', 'Boa Viagem');

-- 20 Professionals (location_id references location.id)
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (1, 'Carlos Silva', 'carlos.silva@example.com', '11980000001', 5, 1);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (2, 'Mariana Souza', 'mariana.souza@example.com', '11980000002', 4, 2);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (3, 'João Pereira', 'joao.pereira@example.com', '11980000003', 5, 3);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (4, 'Ana Oliveira', 'ana.oliveira@example.com', '21990000004', 4, 4);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (5, 'Pedro Gomes', 'pedro.gomes@example.com', '21990000005', 3, 5);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (6, 'Beatriz Costa', 'beatriz.costa@example.com', '31970000006', 5, 6);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (7, 'Rafael Lima', 'rafael.lima@example.com', '41960000007', 4, 7);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (8, 'Fernanda Rocha', 'fernanda.rocha@example.com', '51950000008', 5, 8);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (9, 'Lucas Martins', 'lucas.martins@example.com', '61940000009', 4, 9);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (10, 'Patrícia Fernandes', 'patricia.fernandes@example.com', '81930000010', 5, 10);

INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (11, 'Marcos Azevedo', 'marcos.azevedo@example.com', '11980000011', 3, 2);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (12, 'Sofia Ribeiro', 'sofia.ribeiro@example.com', '11980000012', 5, 1);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (13, 'Tiago Santos', 'tiago.santos@example.com', '11980000013', 4, 3);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (14, 'Laura Mendes', 'laura.mendes@example.com', '21990000014', 5, 4);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (15, 'André Barbosa', 'andre.barbosa@example.com', '21990000015', 2, 5);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (16, 'Camila Nunes', 'camila.nunes@example.com', '31970000016', 4, 6);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (17, 'Diego Castro', 'diego.castro@example.com', '41960000017', 5, 7);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (18, 'Isabela Pinto', 'isabela.pinto@example.com', '51950000018', 3, 8);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (19, 'Vitor Menezes', 'vitor.menezes@example.com', '61940000019', 4, 9);
INSERT INTO professional (id, name, email, phone, rating, location_id) VALUES (20, 'Helena Duarte', 'helena.duarte@example.com', '81930000020', 5, 10);

-- Many-to-Many associations: professional_categories (professional_id, categories_id)
-- Note: The default Hibernate naming for the join table of 'categories' in Professional
-- is often `professional_categories` with columns `professional_id` and `categories_id`.

INSERT INTO professional_categories (professional_id, categories_id) VALUES (1, 1);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (2, 2);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (3, 3);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (4, 4);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (5, 5);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (6, 6);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (7, 7);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (8, 6);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (8, 1);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (9, 4);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (9, 5);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (10, 2);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (10, 3);

INSERT INTO professional_categories (professional_id, categories_id) VALUES (11, 1);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (12, 2);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (13, 5);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (14, 7);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (15, 4);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (16, 3);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (17, 6);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (17, 1);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (18, 7);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (18, 2);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (19, 5);
INSERT INTO professional_categories (professional_id, categories_id) VALUES (20, 3);

-- End of seed data


