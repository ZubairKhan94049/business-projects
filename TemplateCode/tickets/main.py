import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import Select

chrome_path = "C:\selenium_jars_drivers\DRIVERS\chromedriver.exe"
driver = webdriver.Chrome(chrome_path)
LINK = "https://www.ticketswap.com/?language=en"
driver.maximize_window()
driver.get(LINK)



time.sleep(3)
logIn_BTN_XPATH = '//ul[@class="css-9iujih e1oaf4hi11"]//child::li[4]//button'
driver.find_element(By.XPATH, logIn_BTN_XPATH).click()
#
time.sleep(3)
logIn_POP_UP = driver.switch_to.active_element
#
time.sleep(3)
emailBtn = driver.find_element(By.XPATH, '//input[@type="email"]')
emailBtn.send_keys("zubairkhan94049@gmail.com")

submit_btn_xpath = '//button[@type="submit"]'
submit_btn = driver.find_element(By.XPATH, submit_btn_xpath)
submit_btn.click()
time.sleep(5)

controller = input("Have you entered the Code : ? Y/N")
time.sleep(5)

input_search_xpath = '//input[@id="site-search-input"]'
input_search = driver.find_element(By.XPATH, input_search_xpath)
input_search.send_keys("Rotterdam")
time.sleep(3)

i = 0
while True:
    try:
        rtd = driver.switch_to.active_element
        xpath_for_search_drop_down = '//div[@id="site-search-item-0"]'
        driver.find_element(By.XPATH, xpath_for_search_drop_down).click()
        i = 1
    except Exception as e:
        print("Searching ... ")
    if i == 1:
        break


time.sleep(2)
driver.get(driver.current_url)
time.sleep(3)
fst_xpath = '//div[@class="css-iooe8u e34v3qw0"]//child::div//child::a'
fst_btn = driver.find_element(By.XPATH, fst_xpath)
fst_btn.click()

driver.get(driver.current_url)
time.sleep(3)
reguler_xpath = '//ul[@data-testid="event-types-list"]//child::li//child::a'
reguler_btn = driver.find_element(By.XPATH, reguler_xpath)
reguler_btn.click()


driver.get(driver.current_url)
time.sleep(3)
tikt_xpath = '//div[@class="css-zmr4by e151mj0c1"]//child::a'
tikt_btn = driver.find_element(By.XPATH, tikt_xpath)
tikt_btn.click()


driver.execute_script("window.scrollTo(0, 500)")

driver.get(driver.current_url)
time.sleep(3)
buy_tkt_xpath = '//button[@type="submit"]'
driver.execute_script("window.scrollTo(0, 500)")
but_tkt_btn = driver.find_element(By.XPATH, buy_tkt_xpath)
but_tkt_btn.click()


driver.get(driver.current_url)
time.sleep(3)
cnt_btn_xpath = '//button[@class="css-117ynj1 e1dvqv261"]'
cnt_btn = driver.find_element(By.XPATH, cnt_btn_xpath)
cnt_btn.click()


driver.get(driver.current_url)
time.sleep(3)
pyment_xpath = '//input[@id="payment-option"]'
pyment_btn = driver.find_element(By.XPATH, pyment_xpath)
pyment_btn.click()