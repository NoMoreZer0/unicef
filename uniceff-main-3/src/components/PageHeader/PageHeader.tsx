import './PageHeader.scss';

type Props = {};

export function PageHeader(props: Props) {
  return (
    <div className="pageheader">
      <img src="/images/banners/5.jpg" alt="" className="banner"/>
      <div className="pagehead_wrap">
        <div className="container">
          <div className="centered_head">
            {/* TODO buttons if needed*/}
            {/*<div className="button_menu">*/}
            {/*  <a href="/informaciya_psihologam.php" className="head_btn active">Общая*/}
            {/*    информация</a>*/}
            {/*  <a href="/material_psihologam.php" className="head_btn ">Обучающий*/}
            {/*    материал</a>*/}
            {/*</div>*/}
            <div className="pagehead">
              <h1 className="pagename">КОНТАКТЫ</h1>
              <div className="pagedescr">Информация для обратной свзязи</div>
            </div>
          </div>
        </div>
      </div>
    </div>
    // <div className="pageheader">
    //   <img src="/images/banners/1.jpg" alt="" className="banner">
    //     <div className="pagehead_wrap">
    //       <div className="container">
    //         <div className="button_menu">
    //           <a href="/informaciya_psihologam.php" className="head_btn active">Общая
    //             информация</a>
    //           <a href="/material_psihologam.php" className="head_btn ">Обучающий
    //             материал</a>
    //         </div>
    //         <div className="pagehead">
    //           <h1 className="pagename">ПСИХОЛОГАМ</h1>
    //           <div className="pagedescr">Информация для психологов</div>
    //         </div>
    //       </div>
    //     </div>
    // </div>
  );
};