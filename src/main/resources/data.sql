INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Green', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');
INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);

insert into tb_genre(id,name)values(1,'ACAO');
insert into tb_genre(id,name)values(2,'TERROR');
insert into tb_genre(id,name)values(3,'AVENTURA');

insert into tb_movie(id,title,sub_Title,year,img_url,synopsis,genre_id)values(1,'The Witcher','The Witcher',2009,'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg',null,1);
insert into tb_movie(id,title,sub_Title,year,img_url,synopsis,genre_id)values(2,'Venom: Tempo de Carnificina','Venom',2015,'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/vIgyYkXkg6NC2whRbYjBD7eb3Er.jpg',null,1);
insert into tb_movie(id,title,sub_Title,year,img_url,synopsis,genre_id)values(3,'O Espetacular Homem-Aranha 2: A Ameaça de Electro','Homem-Aranha 2',2018,'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/u7SeO6Y42P7VCTWLhpnL96cyOqd.jpg',null,1);
insert into tb_movie(id,title,sub_Title,year,img_url,synopsis,genre_id)values(4,'O Silêncio dos Inocentes','O Silêncio dos Inocentes',2000,'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/mfwq2nMBzArzQ7Y9RKE8SKeeTkg.jpg',null,2);
insert into tb_movie(id,title,sub_Title,year,img_url,synopsis,genre_id)values(5,'O Último Duelo','O Último Duelo',1998,'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/4LrL40XecjGLRpX5I2gzMTUt04l.jpg',null,3);

insert into tb_review (id,text,movie_id,user_id) values(1,'Revisão 1 do filme 1',1,1);
insert into tb_review (id,text,movie_id,user_id) values(2,'Revisão 2 do filme 1',1,1);
insert into tb_review (id,text,movie_id,user_id) values(3,'Revisão 3 do filme 1',1,1);

insert into tb_review (id,text,movie_id,user_id) values(4,'Revisão 1 do filme 2',1,2);
insert into tb_review (id,text,movie_id,user_id) values(5,'Revisão 2 do filme 2',1,2);

insert into tb_review (id,text,movie_id,user_id) values(6,'Revisão 3 do filme 2',2,2);
insert into tb_review (id,text,movie_id,user_id) values(7,'Revisão 4 do filme 2',2,2);

insert into tb_review (id,text,movie_id,user_id) values(10,'Revisão 3 do filme 2',1,2);

insert into tb_review (id,text,movie_id,user_id) values(11,'Revisão 1 do filme 1',2,1);
insert into tb_review (id,text,movie_id,user_id) values(12,'Revisão 1 do filme 1',3,1);

insert into tb_review (id,text,movie_id,user_id) values(13,'Revisão 1 do filme 2',3,2);
insert into tb_review (id,text,movie_id,user_id) values(14,'Revisão 2 do filme 2',3,2);