import time
import selenium
import pandas as pd
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.alert import Alert
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service


#####################################################################
#####################################################################


print()
print("========================================================")
print("::...... Choose Your Option Please ......::")
print()
print("1): To Join Groups")
print("2): To Post in Groups")
print()
print("========================================================")

Join_OR_Post = int(input("Please Enter a Number ||: "))

#####################################################################
#####################################################################

credentials_path = "./credentials.xlsx"
contact_pass = pd.read_excel(credentials_path)
df = pd.DataFrame(contact_pass, columns=['Users', 'Passwords', 'Posts'])

# Lists to store the login credentials (information) of every user
users_name = []     # To store Usernames from csv or Excel file
users_pass = []     # To store Passwords from CSV or Excel file
post_for_single_grp = []


for i in range(len(df.Passwords)):
    users_pass.append(df.Passwords[i])
    users_name.append(df.Users[i])
    post_for_single_grp.append(df.Posts[i])
    
mainCounter = len(df.Passwords)

post = 0
#####################################################################
#####################################################################


chrome_options = Options()
chrome_options.add_argument("--disable-notifications")
URL = "https://www.facebook.com/"


#####################################################################
#####################################################################


def posting(driver, post_controller):
    time.sleep(3)   # After logIn it Will Waite for 3 second to get into Profile
    Profile = driver.find_element(By.XPATH, '//a[@href="/me/"]')
    Profile.click()

    time.sleep(3)
    driver.get(driver.current_url)
    time.sleep(3)
    more = driver.find_element(By.XPATH, '//span[text()="More"]')
    more.click()

    time.sleep(1)
    Groups = driver.find_element(By.XPATH, '//span[text()="Groups"]')
    Groups.click()

    time.sleep(3)
    driver.execute_script("window.scrollBy(0,300)")
    time.sleep(3)
    Groups_Div = driver.find_element(By.XPATH, '/html/body/div[1]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div/div[4]/div/div/div/div/div/div/div/div/div[3]')
    before = 0
    after = 0
    while True:
        driver.execute_script("window.scrollTo(0,document.body.scrollHeight)")
        time.sleep(3)
        all_Links_tag = Groups_Div.find_elements(By.CSS_SELECTOR, 'a[role="link"]')
        before = len(all_Links_tag)
        if before != after:
            after = before
        else:
            break
        time.sleep(2)

    garbage_href = []
    for link in all_Links_tag:
        garbage_href.append(link.get_attribute("href"))

    all_links = []
    for i in range(len(garbage_href)):
        if "members" in garbage_href[i]:
            all_links.append(garbage_href[i])
        else:
            continue

    Groups_link = []
    for link in all_links:
        Groups_link.append(link.replace("members/", ""))

    time.sleep(2)
    i = 0
    for Group_link in Groups_link:
        if i == 5:
            break
        driver.get(Group_link)

        time.sleep(4)
        driver.execute_script("window.scrollTo(0, 200)")
        try:
            time.sleep(3)
            post_section = driver.find_element(By.XPATH, '//span[text() = "Write something..."]')
            post_section.click()

            time.sleep(3)
            Post_pop_up = driver.switch_to.active_element

            time.sleep(3)
            Post_pop_up.send_keys(post_for_single_grp[post_controller])

            time.sleep(10)
            post_btn = driver.find_element(By.XPATH, '//span[text()="Post"]')
            post_btn.click()
            time.sleep(10)
            driver.back()
            i = i+1
        except:
            driver.back()
        time.sleep(5)

#####################################################################
#####################################################################


def joining(driver):
    time.sleep(3)
    groups_Tab_XPATH = '//a[@aria-label="Groups"]'
    while True:
        try:
            driver.find_element(By.XPATH, groups_Tab_XPATH).click()
            print("group tab found and clicked")
            break
        except Exception:
            print("group tab not found .. ")
            pass
    driver.get(driver.current_url)
    while True:
        time.sleep(3)
        try:
            search_groups = driver.find_element(By.CSS_SELECTOR, 'input[aria-label="Search groups"]')
            search_groups.send_keys("real estate")
            search_groups.send_keys(Keys.RETURN)
            print("real state search found and clicked ....")
            break
        except:
            print("real state search not found ....")
            pass

    time.sleep(2)
    driver.get(driver.current_url)
    time.sleep(3)
    while True:
        try:
            driver.execute_script("window.scrollBy(0,300)")
            see_all_XPATH = "//a[@aria-label='See all']"
            SeeAll_btn = driver.find_element(By.XPATH, see_all_XPATH)
            SeeAll_btn.click()
            break
        except:
            time.sleep(2)
            pass
    driver.execute_script("window.scrollBy(0,0)")
    driver.get(driver.current_url)
    time.sleep(5)

    i = 0
    j = 1
    JoiningPath = '//span[text() = "Join Group"]'
    while True:
        if i == 5:
            break
        else:
            time.sleep(3)
            every_grp = "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div[2]/div/div/div/div/div/div["+str(j)+"]/div/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/span/div/a"
            grp = driver.find_element(By.XPATH, every_grp)
            grp.send_keys(Keys.RETURN)
            time.sleep(5)
            try:
                if driver.find_element(By.XPATH, JoiningPath).text == "Join Group":
                    joinBTN = driver.find_element(By.XPATH, JoiningPath)
                    joinBTN.click()
                    time.sleep(2)
                    driver.back()
                    i = i + 1
            except:
                driver.back()
            time.sleep(2)
            driver.execute_script("window.scrollBy(0,300)")
            j = j + 1


for i in range(mainCounter):
    if i == 10:
        break
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=chrome_options)
    driver.maximize_window()

    driver.get(URL)

    user_name = users_name[i]
    user_pass = users_pass[i]

    time.sleep(1)   # Sleep for 1 sec after logIn Page loading
    phone_section = driver.find_element(By.ID, 'email')
    phone_section.send_keys(user_name)

    pass_section = driver.find_element(By.ID, 'pass')
    pass_section.send_keys(user_pass)

    time.sleep(1)  # After filling logIn Section program will wait for 1 sec and will click on logIn button
    driver.find_element(By.NAME, 'login').click()

    if Join_OR_Post == 2:
        posting(driver, post)
        driver.quit()
    elif Join_OR_Post == 1:
        joining(driver)
        driver.quit()
    post = post + 1
    time.sleep(5)
    