#include <iostream>
#include <string>
#include <cstring>
using namespace std;
//Function Declarations
void enterGameLoop();
string askWord(string prompt);
string convertWord(string word);
//Global Variable Declarations
string word = " ";
string again = "n";
//Array declaration
string alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
string leet[62]={"4","8","(","D","3","F","9","H","I","J","K",
"1","M","N","0","P","9","R","5","7","U","V","W","X","Y","2",
"4","b","(","d","3","f","9","h","i","j","k","l","m","n","0",
"p","q","r","5","7","u","v","w","x","y","2","O","I","Z","E","h","S","b","T","X","g"};
int main()
{

    //Enters the main game loop for the program
    enterGameLoop();

    return 0;
}
void enterGameLoop()
{
     do
    {
    word = askWord("\n\nIrja be a forditando szoveget.\n\n>");


    word = convertWord(word);

    cout << word << "\n\nDo you want to enter another word y/n?\n\n>";

    getline(cin,again);
    }
    while(again == "y");
}
string askWord(string prompt)
{

       string word;

       cout << prompt;

       getline(cin,word);

       cout << "\n\n" << word << " -> ";

       return word;
}
string convertWord(string word)
{
      for(size_t i = 0; i < word.size(); i++)
{
   for(int j = 0; j < 62; j++)
   {
      if(word[i] == alphabet[j])
         word.replace(i, leet[j].size(), leet[j]);
   }
}

      return word;
}
