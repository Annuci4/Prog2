#ifndef POLARGEN_H
#define POLARGEN_H

#include <cstdlib>
#include <cmath>
#include <ctime>

class Polargen
{
public:
 PolarGen()
 {
	nincsTarolt = true;
	std::srand (std::time (NULL));
 }
 ~Polargen ()
 {
 }
 double kovetkezo ();

private: 
	bool nincsTarolt;
	double tarolt;
};

#endif
