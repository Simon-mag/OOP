cmake_minimum_required(VERSION 3.16)

project(OOPTesting LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

add_executable(OOPTesting main.cpp
    Beverage.cpp
    VendingMachine.h VendingMachine.cpp
    Beverage.h)

include(GNUInstallDirs)
install(TARGETS OOPTesting
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
