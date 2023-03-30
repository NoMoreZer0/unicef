import * as React from 'react';
import {useEffect, useState} from 'react';
import {FormHeader} from './FormHeader';
import Grid from '@mui/material/Grid';

//Здесь я соберу все суб-компоненты

type Props = {};

export function NewForm1(props: Props) {

  return (
    <>
      <Grid container sx={{padding: "5rem"}}>
        <FormHeader />
      </Grid>
    </>
  );
};