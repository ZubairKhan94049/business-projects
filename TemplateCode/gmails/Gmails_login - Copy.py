import undetected_chromedriver as uc
import pandas as pd
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys
from time import sleep

url = "https://ticketing.liverpoolfc.com/en-gb/categories/home-tickets"
dirver_path = "C:\ChromeDriver\chromedriver.exe"
driver = webdriver.Chrome(dirver_path)
driver.get(url)
sleep(3)
driver.find_element(By.ID, "navMenu_Main_Ballots_item").click

# yt_channel_link_to_subscribe = "https://www.youtube.com/channel/UC6JZx44gSD6-X_8xZoTMXUg"
# yt_sign_in_btn_xpath = '//div[@id="end"]//child::div[@id="buttons"]//child::ytd-button-renderer//child::a'

# credentials_path = "./credentials.xlsx"
# contact_pass = pd.read_excel(credentials_path)
# df = pd.DataFrame(contact_pass, columns=['Emails', 'Passwords'])


# for i in range(len(df.Passwords)):

#     driver = uc.Chrome(use_subprocess=True)
#     driver.maximize_window()

#     driver.get(yt_channel_link_to_subscribe)
#     sleep(2)
#     driver.find_element(By.XPATH, yt_sign_in_btn_xpath).click()

#     driver.find_element(By.XPATH, '//input[@type="email"]').send_keys(df.Emails[i])
#     driver.find_element(By.XPATH, '//*[@id="identifierNext"]/div/button/span').click()
#     sleep(3)

#     driver.find_element(By.XPATH, '//input[@type="password"]').send_keys(df.Passwords[i])
#     driver.find_element(By.XPATH, '//div[@id="passwordNext"]').click()
#     print(driver.title, "   Has been loged in")
#     driver.implicitly_wait(10)
#     driver.close()