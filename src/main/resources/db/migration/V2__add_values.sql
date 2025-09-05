
INSERT into users (user_id, username, email, user_pic, user_pass)
values
    (1,
     'Sofiane',
     'Sofyanekebci@gmail.com',
     'https://plus.unsplash.com/premium_photo-1664474619075-644dd191935f?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8aW1hZ2V8ZW58MHx8MHx8fDA%3D',
     '8dd');

INSERT into items(item_id, item_name, item_descr, item_pic, user_id, created_at, item_loc)
values
   (1,
    'Rock',
    'Just a pretty rock !',
    'https://img.freepik.com/photos-gratuite/vue-cote-aras-ecarlate-vue-pres-tete-ara-ecarlate_488145-3540.jpg?semt=ais_hybrid&w=740&q=80',
    1,
    now(),
    'Marseille');

INSERT  into discovered_objects(disc_id, ob_id, user_id, disc_loc, disc_note, disc_pic, discovered_at)
VALUES
   (1,
    1,
    1,
    'Bordeaux',
    'I found a pretty cool rock',
    'https://img.freepik.com/photos-gratuite/vue-cote-aras-ecarlate-vue-pres-tete-ara-ecarlate_488145-3540.jpg?semt=ais_hybrid&w=740&q=80',
    now());