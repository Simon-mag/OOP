#include <iostream>
#include "VendingMachine.h"
#include "Beverage.h"

using namespace std;


int main()
{
    srand(time(nullptr));

    vector<Beverage> beverages;
    beverages.push_back(Beverage("Fanta", 20, (rand() % 10) + 1));
    beverages.push_back(Beverage("cola", 20, (rand() % 10) + 1));
    beverages.push_back(Beverage("water", 10, (rand() % 10) + 1));
    beverages.push_back(Beverage("cofee", 30, (rand() % 10) + 1));
    beverages.push_back(Beverage("tea", 15, (rand() % 10) + 1));

    VendingMachine vendingmachine(beverages);

    vendingmachine.run();
}
