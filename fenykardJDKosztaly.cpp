#include <iostream>
#include <string>
#include <map>
#include <iomanip>
#include <fstream>
#include <vector>

#include <boost/filesystem.hpp>
#include <boost/filesystem/fstream.hpp>
#include <boost/program_options.hpp>
#include <boost/tokenizer.hpp>
#include <boost/date_time/posix_time/posix_time.hpp>

using namespace std;
using namespace boost::filesystem;


int szamlalo = 0;
void read_file ( boost::filesystem::path path, std::vector<std::string> acts )
{

        if ( is_regular_file ( path ) ) {

                std::string ext ( ".java" );
                if ( !ext.compare ( boost::filesystem::extension ( path ) ) ) {
			cout<<path.string()<<'\n';
                        std::string actpropspath = path.string();
                        std::size_t end = actpropspath.find_last_of ( "/" );
                        std::string act = actpropspath.substr ( 0, end );
			acts.push_back(act);
			szamlalo++;

                }

        } else if ( is_directory ( path ) )
                for ( boost::filesystem::directory_entry & 				entry :boost::filesystem::directory_iterator ( path ) )
                        read_file ( entry.path(), acts );

}


int main ( int argc, char *argv[] )
{

string path="src";
vector<string> acts;
read_file(path,acts);
cout<<"szamlalo: "<<szamlalo<< std::endl;
}
