from select import select
from methods import *
import random
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service


chrome_options_ = Options()
chrome_options_.add_argument("--disable-notifications")
chrome_options_.add_argument("--allow--running-insecure-content")
chrome_options_.add_argument("--ignore-certificate-errors")

website_url = "https://ticketing.liverpoolfc.com/en-gb/categories/home-tickets"
chrome_driver_path = "C:\ChromeDriver\chromedriver.exe"

# driver = webdriver.Chrome(chrome_driver_path, options=chrome_options_)
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=chrome_options_)
driver.maximize_window()


Button_links = []
Tickets_Name = []

username = input("Enter your Support ID : ")
password = input("Enter your Password : ")

driver.get(website_url)
driver.implicitly_wait(10)

driver.find_element(By.ID, "navMenu_Float_login_item").click()
sleep(3)
login_popup = driver.switch_to.active_element
website_login(driver, username, password)

while True:
    driver.get(website_url)
    driver.implicitly_wait(10)

    Buttons = driver.find_elements(By.CLASS_NAME, "itemsButtonsContainer")
    Tickets = driver.find_elements(By.CLASS_NAME, "itemsDataContainer")

    for Ticket in Tickets:
        if Ticket.text in Tickets_Name:
            continue
        else:
            Tickets_Name.append(Ticket.text)


    ##############################################################################################################
    ##############################################################################################################
    # This find the link/href present on the button
    for button in range(len(Buttons)):
        x = '//*[@id="ctl00$body$EventsListControl_btnAddToBasket_' +str(button)+'"]'
        btn_loop = 0
        while True:
            try:
                sleep(2)
                Button = driver.find_element(By.XPATH, x).get_attribute('href')
                if Button in Button_links:
                    continue
                else:
                    Button_links.append(Button)

                    print("\nButton Link found : ", Button)
                break
            except Exception as e:
                if btn_loop == 5:
                    print("Faild! .... Trying to Find Other Button ... ")
                    btn_loop = 0
                    break
                print("Button link not found :: trying to find ..... ")
            btn_loop = btn_loop + 1

    ##############################################################################################################
    ##############################################################################################################


    for link in Button_links:
        driver.get(link)
        choose_seat_btn = 0
        while True:
            try:
                sleep(2)
                driver.find_element(By.CLASS_NAME, "areas-filter-panel__find-button").click()
                driver.remove(link)
                print("\n")
                print("################################################################")
                print("##   Ticket Is Placed into Basket ... ")
                print("################################################################")
                print("\n")
                break
            except:
                if choose_seat_btn == 3:
                    print("...")
                    break
                print("Trying to put another ... ")
            choose_seat_btn = choose_seat_btn + 1



    start_again_duration = random.randint(20, 25)
    print("\n\n")
    print("##############################################################################")
    print("##############################################################################")
    print("##############################################################################")
    print("\n Program Will start again after [", start_again_duration, "] seconds ")
    print("\n\n")

    sleep(start_again_duration)