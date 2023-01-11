from cgi import print_arguments
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import Select

print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
print()
print("Program started ... ")
print()
print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")

chrome_path = "C:\selenium_jars_drivers\DRIVERS\chromedriver.exe"
driver = webdriver.Chrome(chrome_path)

# url = "https://www.ticketswap.com/event/rotterdam-rave-festival-2022/regular-tickets/4e900a61-51ce-4b71-a89a-20d234139c9a/2044403"
url = "https://www.ticketswap.com/event/rotterdam-rave-festival-2022/4e900a61-51ce-4b71-a89a-20d234139c9a"
driver.maximize_window()
driver.get(url)

time.sleep(3)
driver.execute_script("window.scrollTo(0, 500)")
time.sleep(2)

page_referesher = 0
print_once = 1
while True:
    page_referesher = page_referesher + 1
    if page_referesher == 5:
        driver.get(driver.current_url)
        time.sleep(3)
        driver.execute_script("window.scrollTo(0, 500)")

    try:
        not_available_xpath = '//h3[text()="Available"]//following-sibling::span[@class="css-y9qk84 e6fq7ah0"]'
        not_available = driver.find_element(By.XPATH, not_available_xpath)
        if not_available.text() != "No tickets available at the moment.":
            print("Tickets found ...")
            break
    except Exception as e:
        if page_referesher == 5:
            print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
            print()
            print("Page Refereshed, but still No tickets available at the moment.")
            print()
            print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
            page_referesher = 0
            print_once = 1

        if print_once == 1:
            print("No tickets available at the moment.")
            print_once = 0
        time.sleep(1)
