import requests
from bs4 import BeautifulSoup

url = 'https://facebook.com'
reqs = requests.get(url)
soup = BeautifulSoup(reqs.text, 'html.parser')
urls = []

def is_redirected(url_to_check, headers=None):
    r = requests.head(url_to_check, allow_redirects=True, timeout=20)
    if r.history:
        for step in r.history:
            print(f"{r} and {step.status_code} redirects to {step.url}")



for link in soup.find_all('a'):
    if str(link.get('href')).startswith('http'):
        is_redirected(link.get('href'))



