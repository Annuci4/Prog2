#include <iostream>

using namespace std;

class Kacsa {
public:
	virtual void repul(){
		cout<<"Repulok"<<endl;
	};
};

class Program {
public:
	void fgv (Kacsa &kacsa){
		kacsa.repul();
	}
};

class JatekKacsa : public Kacsa
{};

int main (int argc, char **argv)
{
	Program program;
	Kacsa kacsa;
	program.fgv (kacsa);

	JatekKacsa jatek_kacsa;
	program.fgv (jatek_kacsa);
}
