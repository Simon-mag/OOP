#ifndef VENDINGMACHINE_H
#define VENDINGMACHINE_H

#include <vector>
#include "Beverage.h"

using namespace std;

class VendingMachine
{
private:

    double totalPrice;
    int totalPurchases;
    vector<Beverage> beverages;
public:

    VendingMachine(vector<Beverage> beverages);
    void run();
    void displayMeny();
    void dispenseChoice(int choice);
    void printSummary();

    int getTotalPurchases();
    double getTotalPrice();

};

#endif // VENDINGMACHINE_H
