#!/usr/bin/env python3
import time
from itsdangerous import BadTimeSignature
from numpy import append, single
import selenium
import pandas as pd
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.alert import Alert
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service


driver = webdriver.Firefox()
driver.maximize_window()

# //////////////////////////////////////////////////////////////////////////////////////////
# //////////////////////////////////////////////////////////////////////////////////////////
# //////////////////////////////////////////////////////////////////////////////////////////


URL = "https://annuaire.des-pharmacies.fr/departement"
driver.get(URL)


ul = driver.find_element(By.CLASS_NAME, "column-list-society")

time.sleep(3)

all_li = ul.find_elements(By.TAG_NAME, 'a')

# To Store all initials links
all_li_href = []
all_li_text = []

# To store all cards data
all_cards_data = []

# Logic that get all links from single li
for li in all_li:
    all_li_href.append(li.get_attribute("href"))
    all_li_text.append(li.text)


all_phone = []
all_add01 = []
all_add02 = []
all_name = []

name_file = 0  # For Files Name
for href in all_li_href:  # Will get to all linkes one by one
    driver.get(href)
    time.sleep(3)
    driver.get(driver.current_url)
    time.sleep(3)

    # To store single href cards data
    cards_data = []  # to store card body data (add01, add02, phone)

    single_cards_name = []
    single_cards_add01 = []
    single_cards_add02 = []
    single_cards_phon = []

    before = 0
    after = 0
    while True:  # To Scroll Down for the whole div (all cards )
        driver.execute_script("window.scrollTo(0,document.body.scrollHeight)")
        time.sleep(3)
        cards = driver.find_elements(By.CLASS_NAME, "small")
        cards_name = driver.find_elements(By.TAG_NAME, "strong")

        # Controller (Cards length controllers)
        before = len(cards)
        if before != after:
            after = before
        else:
            break

    for card in cards:  # To get all text data from card body
        cards_data.append(card.text)

    j = 0
    # To equate the leng (and removeing the last strong tag)
    for name in cards_name:
        if j < len(cards_name) - 1:
            single_cards_name.append(name.text)
        else:
            break
        j = j+1

    for i in range(len(cards_data)):
        m_lines = cards_data[i].splitlines()
        if len(m_lines) == 1:
            single_cards_add01.append(m_lines[0])
            single_cards_add02.append(0)
            single_cards_phon.append(0)
        elif len(m_lines) == 2:
            single_cards_add01.append(m_lines[0])
            single_cards_add02.append(m_lines[1])
            single_cards_phon.append(0)
        elif len(m_lines) == 3:
            single_cards_add01.append(m_lines[0])
            single_cards_add02.append(m_lines[1])
            single_cards_phon.append(m_lines[2])
        else:
            continue

    for i in range(len(single_cards_name)):
        all_name.append(single_cards_name[i])
        all_add01.append(single_cards_add01[i])
        all_add02.append(single_cards_add02[i])
        all_phone.append(single_cards_phon[i])

    only_single_cards = {
        "Name ": single_cards_name,
        "Address 01": single_cards_add01,
        "Address 02": single_cards_add02,
        "Phone": single_cards_phon
    }
    df = pd.DataFrame(only_single_cards)
    df.to_csv(all_li_text[name_file]+".csv")
    name_file = name_file + 1

    print("/////////////////////////////////////")
    print(all_li_text[name_file]+" ==> Data Has been created ")

    cnt = {
        "Name ": all_name,
        "Address 01": all_add01,
        "Address 02": all_add02,
        "Phone ": all_phone
    }
    df = pd.DataFrame(cnt)
    df.to_csv("cnt.csv")

all_data = {
    "Name ": all_name,
    "Address 01": all_add01,
    "Address 02": all_add02,
    "Phone ": all_phone
}
df = pd.DataFrame(all_data)
df.to_csv("All.csv")
