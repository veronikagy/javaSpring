
create table dictionary1(id int primary key generated always as identity, dictionarykey varchar(5) not null unique); --int(100000)
create table dictionary_value1(id int primary key generated always as identity,
                               dictionaryid1 int references dictionary1(id) on delete cascade, dictionaryvalue varchar(50));


/*create table dictionary2(id int primary key generated always as identity, dictionarykey varchar(4) not null unique);
create table dictionary_value2(id int primary key generated always as identity,
                               dictionaryid2 int references dictionary2(id) on delete cascade, dictionaryvalue varchar(50));


*/
insert into dictionary1(dictionarykey) values ('onee'),('twoo');
insert into dictionary_value1(dictionaryvalue,dictionaryid1) values ('one',1),('один',1),('two',2);

insert into dictionary2(dictionarykey) values ('11111'),('22222');
insert into dictionary_value2(dictionaryvalue,dictionaryid2) values ('one',1),('два',2),('two',2);
