-- 1. Insert data into customers table
INSERT INTO customers (first_name, last_name, email, password, phone, gender, address, city, state, postal_code, country)
VALUES
('John', 'Doe', 'john.doe@example.com', 'password123', '1234567890', 'Male', '123 Elm St', 'New York', 'NY', '10001', 'USA'),
('Jane', 'Smith', 'jane.smith@example.com', 'securePass456', '2345678901', 'Female', '456 Oak Ave', 'Los Angeles', 'CA', '90001', 'USA'),
('Alice', 'Johnson', 'alice.johnson@example.com', 'pass7890', '3456789012', 'Female', '789 Pine Rd', 'Chicago', 'IL', '60007', 'USA'),
('Bob', 'Brown', 'bob.brown@example.com', 'mypassword123', '4567890123', 'Male', '101 Maple Dr', 'San Francisco', 'CA', '94101', 'USA'),
('Charlie', 'Davis', 'charlie.davis@example.com', 'charliePass!', '5678901234', 'Male', '202 Birch Blvd', 'Houston', 'TX', '77001', 'USA'),
('Eve', 'Martinez', 'eve.martinez@example.com', 'EvePass456', '6789012345', 'Female', '303 Cedar Ln', 'Miami', 'FL', '33101', 'USA'),
('Grace', 'Wilson', 'grace.wilson@example.com', 'grace12345', '7890123456', 'Female', '404 Oakwood Dr', 'Seattle', 'WA', '98101', 'USA'),
('Hank', 'Moore', 'hank.moore@example.com', 'hankpassword', '8901234567', 'Male', '505 Pine Ln', 'Dallas', 'TX', '75201', 'USA');

-- 2. Insert data into products table
INSERT INTO products (name, price, description, stockQuantity)
VALUES
('Laptop', 899.99, '15-inch laptop with 8GB RAM', 10),
('Smartphone', 499.99, '5.5-inch smartphone with 128GB storage', 20),
('Tablet', 299.99, '10-inch tablet with 64GB storage', 15),
('Smartwatch', 199.99, 'Water-resistant smartwatch with fitness tracking', 30),
('Headphones', 89.99, 'Wireless Bluetooth headphones', 25),
('Keyboard', 49.99, 'Mechanical keyboard with RGB backlight', 40),
('Mouse', 29.99, 'Wireless ergonomic mouse', 50),
('Webcam', 69.99, 'HD USB webcam with microphone', 18);

-- 3. Insert data into cart table (connects customers and products)
INSERT INTO cart (customer_id, product_id, quantity)
VALUES
(1, 1, 1),  -- John Doe adds Laptop
(2, 2, 2),  -- Jane Smith adds Smartphone
(3, 3, 1),  -- Alice Johnson adds Tablet
(4, 4, 2),  -- Bob Brown adds Smartwatch
(5, 5, 1),  -- Charlie Davis adds Headphones
(6, 6, 3),  -- Eve Martinez adds Keyboard
(7, 7, 2),  -- Grace Wilson adds Mouse
(8, 8, 1);  -- Hank Moore adds Webcam

-- 4. Insert data into orders table (connects customers with orders)
INSERT INTO orders (customer_id, total_price, shipping_address)
VALUES
(1, 899.99, '123 Elm St, New York, NY 10001'),  -- Order by John Doe
(2, 999.98, '456 Oak Ave, Los Angeles, CA 90001'),  -- Order by Jane Smith
(3, 299.99, '789 Pine Rd, Chicago, IL 60007'),  -- Order by Alice Johnson
(4, 399.98, '101 Maple Dr, San Francisco, CA 94101'),  -- Order by Bob Brown
(5, 89.99, '202 Birch Blvd, Houston, TX 77001'),  -- Order by Charlie Davis
(6, 149.97, '303 Cedar Ln, Miami, FL 33101'),  -- Order by Eve Martinez
(7, 59.98, '404 Oakwood Dr, Seattle, WA 98101'),  -- Order by Grace Wilson
(8, 69.99, '505 Pine Ln, Dallas, TX 75201');  -- Order by Hank Moore

-- 5. Insert data into order_items table (connects orders and products)
INSERT INTO order_items (order_id, product_id, quantity)
VALUES
(1, 1, 1),  -- Order 1: John Doe buys Laptop
(2, 2, 2),  -- Order 2: Jane Smith buys Smartphone
(3, 3, 1),  -- Order 3: Alice Johnson buys Tablet
(4, 4, 2),  -- Order 4: Bob Brown buys Smartwatch
(5, 5, 1),  -- Order 5: Charlie Davis buys Headphones
(6, 6, 3),  -- Order 6: Eve Martinez buys Keyboard
(7, 7, 2),  -- Order 7: Grace Wilson buys Mouse
(8, 8, 1);  -- Order 8: Hank Moore buys Webcam

-- 6. Insert data into payments table (connects orders and payments)
INSERT INTO payments (order_id, payment_method, transaction_id, payment_status)
VALUES
(1, 'Credit Card', 'TXN123456789', 'Completed'),  -- Payment for Order 1
(2, 'Debit Card', 'TXN987654321', 'Pending'),  -- Payment for Order 2
(3, 'Net Banking', 'TXN112233445', 'Completed'),  -- Payment for Order 3
(4, 'UPI', 'TXN223344556', 'Completed'),  -- Payment for Order 4
(5, 'Cash on Delivery', 'TXN334455667', 'Pending'),  -- Payment for Order 5
(6, 'Wallet', 'TXN445566778', 'Completed'),  -- Payment for Order 6
(7, 'Credit Card', 'TXN556677889', 'Completed'),  -- Payment for Order 7
(8, 'Debit Card', 'TXN667788990', 'Failed');  -- Payment for Order 8
