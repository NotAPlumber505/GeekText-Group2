CREATE TABLE Books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre_id INT,
    author_id INT,
    publisher_id INT,
    price DECIMAL(3, 2),
    rating DECIMAL(1, 1), -- rating is on a scale of 0.0 (lowest) to 5.0 (highest)
    stock INT,
    sold_copies INT DEFAULT 0, -- Tracks how many copies of this book have been sold
    FOREIGN KEY (genre_id) REFERENCES Genres(genre_id)
    FOREIGN KEY (author_id) REFERENCES Authors(author_id)
    FOREIGN KEY (publisher_id) REFERENCES Publishers(publisher_id)
);

CREATE TABLE Genres (
    genre_id INT AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL
);

CREATE TABLE Authors (
    author_id AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE Publishers (
    publisher_id INT AUTO_INCREMENT PRIMARY KEY,
    publisher_name VARCHAR(255)
);

CREATE TABLE Sales (
    sale_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    sale_date DATE,
    quantity INT,
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

INSERT INTO Genres (genre_name) VALUES
('Superhero'),
('Manga'),
('Slice-of-Life'),
('Horror'),
('Non-fiction'),
('Science-Fiction/Fantasy'),
('Children'),
('Adult'),
('Alternative');

INSERT INTO Authors (first_name, last_name) VALUES
('Stan', 'Lee'), -- author of Marvel Comics (Superhero)
('Masashi', 'Kishimoto'), -- author of Naruto (Manga)
('Raina', 'Telgemeier'), -- author of Smile (Slice-of-Life)
('Junji', 'Ito'), -- author of Uzumaki, Tomie (Horror)
('Jessica', 'Abel'), -- author of La Perdida (Non-fiction)
('J.R.R. Tolkien'), -- author of LOTR (Sci-Fi/Fantasy)
('John', 'Porcellino'), -- author of King-Cat Comics (Children)
('Sui', 'Ishida'), -- author of Tokyo Ghoul, Tokyo Revengers (Adult)
('Daniel', 'Clowes'); -- author of Ghost World, Clowes (Alternative)

INSERT INTO Publishers (publisher_name) VALUES
('Marvel Comics'), -- Superhero
('Kodansha'), -- Manga
('First Second Books'), -- Slice-of-Life
('Shogakukan'), -- Horror
('Pantheon Books'), -- Non-fiction
('Houghton Mifflin'), -- Sci-Fi/Fantasy
('Harry N. Abrams, Inc.'), -- Children
('Viz Media'), -- Adult
('Fantagraphics Books'); -- Alternative

INSERT INTO Books (title, genre_id, author_id, publisher_id, price, rating, stock, sold_copies) VALUES
('The Amazing Spider-Man #1 (1963)', 1, 1, 1, 9.99, 4.8, 30, 600)
('Naruto, Vol 1: Uzumaki Naruto (2000)', 2, 2, 2, 10.79, 4.4, 40, 250),
('Smile (2010)', 3, 3, 3, 6.99, 4.7, 20, 120),
('Uzumaki: Spiral into Horror, Vol. 1 (2007)', 4, 4, 4, 29.99, 4.4, 20, 300),
('La Perdida (2008)', 5, 5, 5, 17.49, 4.1, 20, 60),
('Lord of the Rings - One Volume Edition (1994)', 6, 6, 6, 17.99, 4.9, 50, 700),
('King-Cat Classix (2007)', 7, 7, 7, 24.99, 4.5, 50, 250),
('Tokyo Ghoul, Vol. 1 (2015)', 8, 8, 8, 8.79, 4.8, 30, 100),
('Ghost World s/c (2015)', 9, 9, 9, 12.49, 4.5, 20, 80);

INSERT INTO Sales (book_id, sale_date, quantity) VALUES
(1, '2025-02-02', 50),
(2, '2025-02-03', 60),
(3, '2025-02-04', 180),
(4, '2025-02-05', 30),
(5, '2025-02-06', 90),
(6, '2025-02-07', 80),
(7, '2025-02-08', 100),
(8, '2025-02-09', 40),
(9, '2025-02-10', 70);
