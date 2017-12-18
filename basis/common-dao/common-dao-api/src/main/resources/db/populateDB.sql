DELETE FROM user_roles;
DELETE FROM user_update_data;
DELETE FROM users;

INSERT INTO users(name, first_name, last_name, phone, email, password)
    VALUES ('admin', 'Jon', 'Snow', '+380634401122', 'admin@gmail.com', 'admin_password'),
           ('seller', 'Tiriron', 'Lanister', '+380674403344', 'seller@gmail.com', 'seller_password'),
           ('buyer', 'Ned', 'Stark', '+380632536571', 'buyer@gmail.com', 'buyer_password');

INSERT INTO user_roles(user_id, role)
    VALUES (100, 'ADMIN'),
           (100, 'SELLER'),
           (100, 'BUYER'),
           (101, 'SELLER'),
           (101, 'BUYER'),
           (102, 'BUYER');

INSERT INTO user_update_data(phone, email, password, user_id)
    VALUES ('+777777777', null, 'admin123_password', 100),
           ('+888888888', 'admin1238@gmail.com', 'admin1238_password', 100),
           ('+3806744033442', NULL , 'seller_password2', 101);
