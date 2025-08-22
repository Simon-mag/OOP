#ifndef BEVERAGE_H
#define BEVERAGE_H

#pragma once
#include <string>
using namespace std;

class Beverage
{
private:

    string name;
    double price;
    int stock;
public:

    Beverage(string name, double price, int stock);

    void setName(string name);
    void setPrice(double price);
    void setStock(int stock);
    void decreaceStock();
    string getName();
    double getPrice();
    int    getStock();
};

#endif // BEVERAGE_H
