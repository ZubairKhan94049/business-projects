from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
from time import sleep

##################################################################################################################
##################################################################################################################


######################################################################################

def check_internet():
    print("\n\n")
    print("############################################################")
    print("###################Please Check Internet#####################")
    print("############################################################")
    quit()

######################################################################################

def website_login(webpage, uname, password):
    sleep(2)
    webpage.find_element(By.ID, "username").send_keys(uname)
    sleep(2)
    webpage.find_element(By.ID, "password").send_keys(password)
    sleep(2)
    webpage.find_element(By.ID, "btnLogin").click()

######################################################################################
