import Grid from '@mui/material/Grid';
import {useEffect, useState} from 'react';
import {styled} from '@mui/material/styles';
import Paper from '@mui/material/Paper';
import "./NewForm.scss"


const Item = styled(Paper)(({theme}) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));
type Props = {};

export function FormHeader(props: Props) {

  return (
    <>
      <Grid xs={12}>
        <Item><span className='header'>ПЕРВИЧНАЯ ОЦЕНКА</span><br></br>
          <p className='subheader'>Данная форма заполняется для того, чтобы выявить ВОЗМОЖНЫЕ факторы риска выбытия ребенка из школы, и более подробно изучить ситуацию ребенка и определить уровень риска переведя его на форму Глубинной оценки. Первичная оценка является фильтром. </p>
        </Item>
      </Grid>
      <Grid xs={6}>
        <label>Дата проведения: </label>
        <input type="text" />
      </Grid>
      <Grid xs={6}>
        <Item>xs=4</Item>
      </Grid>
      <Grid xs={8}>
        <Item>xs=8</Item>
      </Grid>
    </>
  );
};