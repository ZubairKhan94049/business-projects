import requests



proxy = '117.54.114.32:80'




r = requests.get('https://httpbin.org/ip', proxies={'http':proxy, 'https':proxy}, timeout=2)
print(r.status_code) # 200 mean we are connected fine 
print(r.text)