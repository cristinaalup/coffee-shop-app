CREATE TABLE Customer (
    CustomerId INT IDENTITY(1,1) PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Email VARCHAR(255)
);

CREATE TABLE Product (
    ProductId INT IDENTITY(1,1) PRIMARY KEY,
    Type VARCHAR(255),
    Description VARCHAR(255),
    Price DECIMAL(10,2)
);

CREATE TABLE CustomerOrder (
    OrderId INT IDENTITY(1,1) PRIMARY KEY,
    CustomerId INT,
    TotalPrice DECIMAL(10,2),
    OrderDate DATE,
    FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId)
);

CREATE TABLE OrderProduct (
    OrderId INT NOT NULL,
    ProductId INT NOT NULL,
    Quantity INT NOT NULL,
    PRIMARY KEY (OrderId, ProductId),
    FOREIGN KEY (OrderId) REFERENCES CustomerOrder(OrderId),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
);