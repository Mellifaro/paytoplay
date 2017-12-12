DELETE FROM user_roles;
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
