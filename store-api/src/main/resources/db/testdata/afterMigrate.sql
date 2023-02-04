delete from book_category;
delete from book_sub_category;
delete from sub_category;
delete from category;
delete from book;

alter table book auto_increment=1;
alter table category auto_increment=1;
alter table sub_category auto_increment=1;

insert into book (author, brand, description, finishing, inventory, isbn, language, name, number_of_pages, offer, original_title, price, publishing_company, year)
values ('Cass, Kiera', 'WMF Martins Fontes', 'Muitas garotas sonham em ser princesas, mas este não é o caso de America Singer. Ela topa se inscrever na Seleção só para agradar a mãe, certa de que não será sorteada para participar da competição em que o príncipe escolherá sua futura esposa. Mas é claro que depois disso sua vida nunca mais será a mesma... Para trinta e cinco garotas, a Seleção é a chance de uma vida. É a oportunidade de ser alçada a um mundo de vestidos deslumbrantes e joias valiosas. De morar em um palácio, conquistar o coração do belo príncipe Maxon e um dia ser a rainha. America Singer, no entanto, estar entre as Selecionadas é um pesadelo. Significa deixar para trás o rapaz que ama. Abandonar sua família e seu lar para entrar em uma disputa ferrenha por uma coroa que ela não quer. E viver em um palácio sob a ameaça constante de ataques rebeldes. Então America conhece pessoalmente o príncipe - e percebe que a vida com que sempre sonhou talvez não seja nada comparada ao futuro que nunca tinha ousado imaginar.',
        'Livro brochura (paperback)', 500, '9788565765015', 'Português', 'A Seleção', 368, 39.90, 'A Seleção', 49.90, 'Editora Schwarcz SA', 2012);

insert into book (author, brand, description, finishing, inventory, isbn, language, name, number_of_pages, offer, original_title, price, publishing_company, year)
values ('Hill, Napoleon', 'Citadel', 'Compre na Saraiva o livro Mais Esperto que o Diabo O Mistério Revelado da Liberdade e do Sucesso com mais de 100 milhões de copias vendidas no mundo. O seu propósito, escrito com suas próprias palavras, é ajudar o ser humano a descobrir o seu real potencial, desvendando as armadilhas mentais que os homens e as mulheres deste mundo criam para si mesmos, sabotando a sua própria liberdade e o seu próprio direito de viver uma vida cheia de desafios, alegria e liberdade. Escrito em 1938, após uma das maiores crises econômicas, e precedendo a Segunda Guerra Mundial, este livro não somente é uma fonte de inspiração e coragem, mas deve ser considerado um manual para todas aquelas pessoas que desejam',
        'Livro brochura (paperback)', 609, '9788568014004', 'Português', 'Mais esperto que o Diabo', 208, 39.90, 'Mais esperto que o Diabo', 49.90, 'CDG Edições e Publicações Eireli', 2014);

insert into category (name) values ('Literatura Infantojuvenil');
insert into category (name) values ('Autoajuda');
insert into category (name) values ('Artes');
insert into category (name) values ('Literatura Estrangeira');

insert into sub_category (name) values ('Literatura Juvenil');
insert into sub_category (name) values ('Desenvolvimento Pessoal');
insert into sub_category (name) values ('Romance');
insert into sub_category (name) values ('Poesia');

insert into book_category (category_id, book_id) values (1, 1);
insert into book_category (category_id, book_id) values (2, 2);

insert into book_sub_category (sub_category_id, book_id) values (1, 1);
insert into book_sub_category (sub_category_id, book_id) values (2, 2);