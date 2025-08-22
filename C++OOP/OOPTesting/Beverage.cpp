#include "Beverage.h"

Beverage::Beverage(string name, double price, int stock)
    : name(name), price(price), stock(stock) {}

void Beverage::setName(string name){this->name = name;}
void Beverage::setStock(int stock){this->stock = stock;}
void Beverage::setPrice(double price){this->price = price;}

void Beverage:: decreaceStock(){
    if(this->stock <= 0)
        return;
    this->stock--;
}

int Beverage::getStock(){return stock;}
string Beverage::getName(){return name;}
double Beverage::getPrice(){return price;}
