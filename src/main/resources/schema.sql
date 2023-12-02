create table dictionary1
(
    dictionary_key   VARCHAR(4),
    dictionary_value VARCHAR(64)
);
create table dictionary2
(
    dictionary_key   INTEGER,
    dictionary_value VARCHAR(64)
);

insert into dictionary1(dictionary_key, dictionary_value)
VALUES ( 'five', 'five' ),
       ('seve', 'seven');
insert into dictionary2(dictionary_key, dictionary_value)
VALUES ( '55555', 'five' ),
       ('77777', 'seven');