# Payment Service

## Project Overview

This project is a Payment Service API that handles payment processing for an e-commerce platform. It is built using Spring Boot and uses a microservices architecture.

## Features

* Process payments
* Handle payment failures
* Integrate with Product Service

## Technologies Used

* Spring Boot
* RESTful APIs
* Microservices architecture
* Relational databases

## How it Works

1. The Payment Service receives a payment request from the Product Service.
2. The Payment Service processes the payment using a payment gateway.
3. If the payment is successful, the Payment Service updates the payment status in the database.
4. If the payment fails, the Payment Service sends an error response to the Product Service.

## Flow

1. Product Service -> Payment Service (Payment Request)
2. Payment Service -> Payment Gateway (Process Payment
