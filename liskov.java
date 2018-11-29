class Bird {
public:
    virtual void setLocation(double longitude, double latitude) = 0;
    virtual void setAltitude(double altitude) = 0;
    virtual void draw() = 0;
};
void Penguin::setAltitude(double altitude)
{
    //altitude can't be set because penguins can't fly
    //this function does nothing
}

//Solution 1: The wrong way to do it
void ArrangeBirdInPattern(Bird* aBird)
{
    Pengiun* aPenguin = dynamic_cast<Pengiun*>(aBird);
    if(aPenguin)
        ArrangeBirdOnGround(aPenguin);
    else
        ArrangeBirdInSky(aBird);
}

//Solution 2: An OK way to do it
void ArrangeBirdInPattern(Bird* aBird)
{
    if(aBird->isFlightless())
        ArrangeBirdOnGround(aBird);
    else
        ArrangeBirdInSky(aBird);
}

//Solution 3: Proper inheritance
class Bird {
public:
    virtual void draw() = 0;
    virtual void setLocation(double longitude, double latitude) = 0;
};

class FlightfulBird : public Bird {
public:
    virtual void setAltitude(double altitude) = 0;
};
