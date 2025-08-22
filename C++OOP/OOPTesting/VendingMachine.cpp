#include "VendingMachine.h"
#include <iostream>

using namespace std;

VendingMachine::VendingMachine(vector<Beverage> beverages){
    this->beverages = beverages;
    this->totalPrice = 0;
    this->totalPurchases = 0;
}

void VendingMachine::run(){
    int choice;

    while(true){

        displayMeny();
        cin >> choice;
        if(choice == beverages.size()+1)
            break;
        dispenseChoice(choice);
    }
    printSummary();
}


void VendingMachine::displayMeny(){
    int i = 1;
    cout << "Vending menu:\n\n";

    for(Beverage beverage : beverages){
        cout << i << " " << beverage.getName() << " :: " << beverage.getPrice() << "kr :: " << beverage.getStock() << endl;
        ++i;
    }
    cout << i << " Exit\nEnter Choice:";
}


void VendingMachine::dispenseChoice(int choice){

    Beverage& beverage = beverages[choice-1];
    if(beverage.getStock() <= 0){
        cout << "\nno more in stock! \n\n";
        return;
    }

    cout << "\nFetching " << beverage.getName() << " >>\n\n";

    totalPrice += beverage.getPrice();
    beverage.decreaceStock();
    ++totalPurchases;
}

void VendingMachine::printSummary(){

    cout << "\n\nYou purchased " << totalPurchases << " thing(s) for "
         << totalPrice << " Kr!" << endl;
}

double VendingMachine::getTotalPrice(){return totalPrice;}
int VendingMachine::getTotalPurchases(){return totalPurchases;}
