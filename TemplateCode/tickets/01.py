import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import Select

chrome_path = "C:\selenium_jars_drivers\DRIVERS\chromedriver.exe"
driver = webdriver.Chrome(chrome_path)
main_LINK = "https://www.ticketswap.com/?language=en"
link_for_rotterdam = "https://www.ticketswap.com/city/rotterdam/5"

driver.maximize_window()
driver.get(main_LINK)

print("Window Is Loaded ... ")

# --############################################################################################ --->> Window Is Loaded

# --############################################################################################ --->> Now I have to LogIn ..

print("Now It is going to login ... ")

# To wait for the page fully loaded .. to find the login button and click on it

time.sleep(5)
while True:
    try:
        logIn_BTN_XPATH = '//ul[@class="css-9iujih e1oaf4hi11"]//child::li[4]//button'
        driver.find_element(By.XPATH, logIn_BTN_XPATH).click()
        print("Login Buttong found and Clicked ... ")
        break
    except Exception as e:
        time.sleep(2)
        print("Log-In Button not found Just wait ... ")

# --############################################################################################ --->> Pop Up appeared -> Driver will switch to active window
# Going to enter it mail ...
time.sleep(1)
login_popup = driver.switch_to.active_element
emailBtn = driver.find_element(By.XPATH, '//input[@type="email"]')
emailBtn.send_keys("zubairkhan94049@gmail.com")

# After typing Email --> Need to click on submit

submit_btn_xpath = '//button[@type="submit"]'
submit_btn = driver.find_element(By.XPATH, submit_btn_xpath)
submit_btn.click()


# This will wait until the code is being entered that is sended to your email ...
while True:
    controller_until_code_entered = input("Did you Entered ? Y/N : ")
    if controller_until_code_entered == "y" or controller_until_code_entered == 'Y':
        break

driver.get(link_for_rotterdam)
