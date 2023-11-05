################################################################################
#     ____                          __     _                          ___
#    / __ \  __  __  ___    _____  / /_   (_)  ____    ____          <  /
#   / / / / / / / / / _ \  / ___/ / __/  / /  / __ \  / __ \         / / 
#  / /_/ / / /_/ / /  __/ (__  ) / /_   / /  / /_/ / / / / /        / /  
#  \___\_\ \__,_/  \___/ /____/  \__/  /_/   \____/ /_/ /_/        /_/   
#                                                                        
#  Question 1
################################################################################
#
# Instructions:
# The two functions below are used to tell the weather. They have some bugs that
# need to be fixed. The test suite in `question1_test.py` will verify the output.
# Read the test suite to know the values that these functions should return.

city_info = {
    "Quito": {"temperature": 22, "weather": "sunny"},
    "Sao Paulo": {"temperature": 17, "weather": "cloudy"},
    "San Francisco": {"temperature": 16, "weather": None},
    "New York": {"temperature": 14, "weather": "rainy"},
}


def get_city_temperature(city):
   return city_info.get(city, {}).get("temperature")



def get_city_weather(city):
   sky_condition = city_info.get(city, {}).get("weather")


   temperature = get_city_temperature(city)


   return str(temperature) + " degrees and " + sky_condition