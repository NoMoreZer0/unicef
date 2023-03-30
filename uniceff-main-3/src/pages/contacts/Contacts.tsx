// @flow
import * as React from 'react';
import PageHeader from '../../components/PageHeader';

type Props = {};

export function Contacts(props: Props) {
  return (
    <>
      <PageHeader/>
      <div className="pt50 pb50">
        <div className="container">
          <div className="contacts_page">
            <div className="cont_row mb50">
              <div className="cont_col cont_col1">
                <div className="ctitle">Адрес:</div>
                <div className="c_info">
                  <img src="/images/icons/c_phone.svg" alt=""/>
                  <div className="cval">
                    республика Казахстан, г. Нур-Султан, улица, дом здание
                  </div>
                </div>
              </div>
              <div className="cont_col cont_col2">
                <div className="ctitle">Телефон:</div>
                <div className="c_info">
                  <img src="/images/icons/c_phone.svg" alt=""/>
                  <div className="cval">
                    <a href="tel:+7 (7172) 77 77 77">+7 (7172) 77 77 77</a>
                  </div>
                </div>
              </div>
              <div className="cont_col cont_col3">
                <div className="ctitle">Электронная почта:</div>
                <div className="c_info">
                  <img src="/images/icons/c_mail.svg" alt=""/>
                  <div className="cval">
                    <a href="mailto:info@examplemail.kz">info@examplemail.kz</a>
                  </div>
                </div>
              </div>
            </div>
            <div className="cont_map">
              <img src="/images/map.jpg" alt=""/>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};