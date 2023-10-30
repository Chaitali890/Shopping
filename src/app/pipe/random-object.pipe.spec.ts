import { RandomObjectPipe } from './random-object.pipe';

describe('RandomObjectPipe', () => {
  it('create an instance', () => {
    const pipe = new RandomObjectPipe();
    expect(pipe).toBeTruthy();
  });
});
