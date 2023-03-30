import './Footer.scss'
type Props = {

};

export function Footer(props: Props) {
  return (
    <footer>
      <div className="container">
        <div className="footer_top">
          <div className="fcol fcol1">
            <a href="/" className="flogo"><img src="/images/flogo.svg"
              alt="" /></a>
            <div className="flogo_text">Электронный методический центр для
              психологического сопровождения учащихся
            </div>
          </div>
          <div className="fcol fcol2">
            <div className="ftitle">ПСИХОЛОГАМ</div>
            <ul className="fmenu">
              <li><a href="">Общая информация</a></li>
              <li><a href="">Обучающий материал </a></li>
            </ul>
          </div>
          <div className="fcol fcol3">
            <div className="ftitle">УЧЕНИКАМ</div>
            <ul className="fmenu">
              <li><a href="">Общая информация</a></li>
              <li><a href="">Обучающий материал </a></li>
            </ul>
          </div>
          <div className="fcol fcol4">
            <a href="" className="ftitle">О ПОРТАЛЕ</a>
            <a href="" className="ftitle">МЕДИА</a>
            <a href="" className="ftitle">КОНТАКТЫ</a>
          </div>
          <div className="fcol fcol5">
            <a className="green_btn" href="/">ВЫЙТИ</a>
          </div>
        </div>
        <div className="footer_bottom">

        </div>
      </div>
    </footer>
  );
};